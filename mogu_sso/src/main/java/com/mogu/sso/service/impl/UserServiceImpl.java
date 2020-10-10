package com.mogu.sso.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.alibaba.fastjson.JSONObject;
import com.mogu.sso.dao.JedisClient;
import com.mogu.sso.service.UserService;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;

import taotao_common.TaotaoItemResult;
import taotao_utils.CookieUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper tbUserMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${redis.user.session.key}")
	private String REDIS_USER_SESSION_KEY;
	
	@Value("${redis.user.session.expire.time}")
	private Integer USER_SESSION_EXPIRE_TIME;
	
	/**
	 * 根据信息类别检测登录信息是否可用
	 * 1：username
	 * 2：phone
	 * 3：email
	 */
	@Override
	public TaotaoItemResult checkLoginData(String param, Integer type) {
		TbUserExample example = new TbUserExample();
		
		Criteria criteria = example.createCriteria();
		// 根据check数据
		if(type == 1) {
			criteria.andUsernameEqualTo(param);
		}else if(type == 2) {
			criteria.andPhoneEqualTo(param);
		}else if (type == 3) {
			criteria.andEmailEqualTo(param);
		}
		
		List<TbUser> list = tbUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0)
			return TaotaoItemResult.ok(false);
		
		return TaotaoItemResult.ok(true);
	}

	/**
	 * 用户注册
	 */
	@Override
	public TaotaoItemResult register(TbUser user) {
		user.setCreated(new Date());
		user.setUpdated(new Date());
		// 利用spring自带的加密工具加密，DigestUtils
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		tbUserMapper.insert(user);
		return TaotaoItemResult.ok();
	}

	/**
	 * 用户登录,同时实现cookie共享
	 */
	@Override
	public TaotaoItemResult login(String username, String password,
			HttpServletRequest request,HttpServletResponse response) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		
		//查找用户名
		if(list==null || list.size()==0) {
			return TaotaoItemResult.build(400, "用户名或密码错误");
		}
		
		TbUser user = list.get(0);
//		System.out.println(user.getPassword());
		//匹配密码：md5无法逆转，可用加密后的字符串进行比较
		if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			return TaotaoItemResult.build(400, "用户名或密码错误");
		}
		//生成token：redis缓存中用于索引用户信息的key
		String token=UUID.randomUUID().toString();
		String jedisKey=REDIS_USER_SESSION_KEY+":"+token;
		
		//将token存入redis并设置过期时间
		//存入之前，将user对象的密码清空，防止信息泄露
		user.setPassword(null);
		jedisClient.set(jedisKey, JSONObject.toJSONString(user));
		jedisClient.expire(jedisKey, USER_SESSION_EXPIRE_TIME);
		
		//将token写入cookie（cookie共享，使得其他系统能够登录一次即可访问）
		CookieUtils.setCookie(request, response, "MG_TOKEN", token);
		//返回索引token
		return TaotaoItemResult.ok(token);
	}

	/**
	 * 根据所给token获取用户信息
	 */
	@Override
	public TaotaoItemResult getUserByToken(String token) {
		
		String jedisKey=REDIS_USER_SESSION_KEY+":"+token;
		String json = jedisClient.get(jedisKey);
//		System.out.println(json);
		if(StringUtils.isBlank(json)) {
			return TaotaoItemResult.build(400, "当前session的token已过期");
		}
		
		//重新设置过期时间
		jedisClient.expire(jedisKey, USER_SESSION_EXPIRE_TIME);
		
		return TaotaoItemResult.ok(JSONObject.parseObject(json,TbUser.class));
	}

	/**
	 * 根据token删除redis中的用户session信息
	 */
	@Override
	public TaotaoItemResult deleteUserByToken(String token,
			HttpServletRequest request,HttpServletResponse response) {
		String jedisKey = REDIS_USER_SESSION_KEY + ":" +token;
		jedisClient.del(jedisKey);
//		CookieUtils.deleteCookie(request, response, "MG_TOKEN");
		return TaotaoItemResult.ok();
	}

}
