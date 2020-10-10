package com.mogu.manager.service.impl;

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
import com.mogu.manager.dao.JedisClient;
import com.mogu.manager.service.AdminService;
import com.taotao.mapper.TbAdminMapper;
import com.taotao.pojo.TbAdmin;
import com.taotao.pojo.TbAdminExample;
import com.taotao.pojo.TbAdminExample.Criteria;

import taotao_common.TaotaoItemResult;
import taotao_utils.CookieUtils;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private TbAdminMapper adminMapper;

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_ADMIN_TOKEN}")
	private String REDIS_ADMIN_TOKEN;
	
	@Value("${REDIS_ADMIN_SESSION_KEY}")
	private String REDIS_ADMIN_SESSION_KEY;
	
	@Value("${ADMIN_SESSION_EXPIRE_TIME}")
	private Integer ADMIN_SESSION_EXPIRE_TIME;

	/**
	 * 修改管理员信息
	 */
	@Override
	public TaotaoItemResult updateAdmin(TbAdmin admin) {
		try {
			//补全pojo
			admin.setUpdated(new Date());
			//添加update条件
			TbAdminExample example = new TbAdminExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(admin.getUsername());
			//update数据
			adminMapper.updateByExampleSelective(admin, example);			
			return TaotaoItemResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, "更新失败！");
		}
	}
	
	/**
	 * 根据类型验证数据
	 * 1：用户名 2：电子邮箱 3：手机号
	 */
	@Override
	public TaotaoItemResult checkAdminData(String param, Integer type) {
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		
		//验证数据类型：1：用户名 2：电子邮箱 3：手机号
		if(type == 1) {
			criteria.andUsernameEqualTo(param);
		}else if (type == 2) {
			criteria.andEmailEqualTo(param);
		}else if(type == 3){
			criteria.andPhoneEqualTo(param);
		}else {
			return TaotaoItemResult.build(500, "数据异常！");
		}
		
		List<TbAdmin> list = adminMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return TaotaoItemResult.ok(false);
		}
		return TaotaoItemResult.ok(true);
	}
	
	/**
	 * 修改管理员密码
	 */
	@Override
	public TaotaoItemResult updateAdminPassword(String old,String news,HttpServletRequest request,
			HttpServletResponse response) {
		
		//获取redis中的管理员信息
		String token = CookieUtils.getCookieValue(request, "MG_ADMIN");
		String json = jedisClient.get(REDIS_ADMIN_SESSION_KEY+":"+token);
		if(StringUtils.isBlank(json)) {
			return TaotaoItemResult.ok("请重新登录");
		}
		TbAdmin admin = JSONObject.parseObject(json, TbAdmin.class);
		//检验原密码
		TbAdmin tbAdmin = adminMapper.selectByPrimaryKey(admin.getId());
		if(!DigestUtils.md5DigestAsHex(old.getBytes()).equals(tbAdmin.getPassword())) {
			return TaotaoItemResult.build(500, "修改密码错误!");
		}
		//补全管理员id
		tbAdmin.setUpdated(new Date());
		tbAdmin.setPassword(DigestUtils.md5DigestAsHex(news.getBytes()));			

		//修改密码
		adminMapper.updateByPrimaryKeySelective(tbAdmin);
		//删除cookie
		CookieUtils.deleteCookie(request, response, "MG_ADMIN");
		jedisClient.del(REDIS_ADMIN_SESSION_KEY+":"+token);
		return TaotaoItemResult.ok();
	}

	

	/**
	 * 管理员登录 
	 */
	@Override
	public TaotaoItemResult login(String username, String password,
			HttpServletRequest request,HttpServletResponse response) {
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbAdmin> list = adminMapper.selectByExample(example);
		
		//查找用户名
		if(list==null || list.size()==0) {
			return TaotaoItemResult.build(400, "用户名或密码错误");
		}
		
		//查找密码
		TbAdmin admin = list.get(0);
		if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(admin.getPassword())) {
			return TaotaoItemResult.build(400, "用户名或密码错误");
		}
		//生成token：redis缓存中用于索引用户信息的key
		String token=UUID.randomUUID().toString();
		String jedisKey=REDIS_ADMIN_SESSION_KEY+":"+token;
		
		//将token存入redis并设置过期时间
		//存入之前，将user对象的密码清空，防止信息泄露
		admin.setPassword(null);
		jedisClient.set(jedisKey, JSONObject.toJSONString(admin));
		jedisClient.expire(jedisKey, ADMIN_SESSION_EXPIRE_TIME);
		//将token存入cookie：一台电脑只能登录一个 
//		jedisClient.set(REDIS_ADMIN_TOKEN,token);
		CookieUtils.setCookie(request, response, "MG_ADMIN", token);
		return TaotaoItemResult.ok(token);
	}
	
	/**
	 * 根据所给token获取用户信息
	 */
	@Override
	public TbAdmin getAdminByToken(String token) {
		
		String jedisKey=REDIS_ADMIN_SESSION_KEY+":"+token;
		String json = jedisClient.get(jedisKey);
		if(StringUtils.isBlank(json)) {
			return null;
		}
		
		//重新设置过期时间，一小时
		jedisClient.expire(jedisKey, ADMIN_SESSION_EXPIRE_TIME);
		
		return JSONObject.parseObject(json,TbAdmin.class);
	}

	/**
	 * 管理员退出：根据token删除redis中的用户session信息
	 */
	@Override
	public TaotaoItemResult deleteAdmin(HttpServletRequest request,HttpServletResponse response) {
		String token = CookieUtils.getCookieValue(request, "MG_ADMIN");
		String jedisKey = REDIS_ADMIN_SESSION_KEY + ":" +token;
		jedisClient.del(jedisKey);
		CookieUtils.deleteCookie(request, response, "MG_ADMIN");
		return TaotaoItemResult.ok();
	}

//	/**
//	 * 根据数据类型，修改old为news
//	 */
//	@Override
//	public TaotaoItemResult updateAdminByType(String old,String news, Integer type) {
//		TbAdmin admin = new TbAdmin();
//		TbAdminExample example = new TbAdminExample();
//		Criteria criteria = example.createCriteria();
//		
//		//验证数据类型：1：用户名 2：电子邮箱 3：手机号
//		if(type == 1) {
//			admin.setUsername(news);
//			criteria.andUsernameEqualTo(old);
//		}else if (type == 2) {
//			admin.setEmail(news);
//			criteria.andEmailEqualTo(old);
//		}else if (type ==  3) {
//			admin.setPhone(news);
//			criteria.andPhoneEqualTo(old);
//		}else {
//			return TaotaoItemResult.build(500, "输入的更新数据异常");
//		}
//		
//		adminMapper.updateByExampleSelective(admin, example);
//		return null;
//	}

}
