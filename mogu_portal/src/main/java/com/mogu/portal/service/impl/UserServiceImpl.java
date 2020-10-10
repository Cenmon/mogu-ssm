package com.mogu.portal.service.impl;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mogu.portal.service.UserService;
import com.taotao.pojo.TbUser;

import taotao_utils.HttpClientUtil;

@Service
public class UserServiceImpl implements UserService {

	@Value("${SSO_BASE_URL}")
	private String SSO_BASE_URL;
	
	@Value("${SSO_USER_SESSION_TOKEN}")
	private String SSO_USER_SESSION_TOKEN;
	
	@Value("${SSO_PAGE_LOGIN}")
	private String SSO_PAGE_LOGIN;
	
	/**
	 * protal系统
	 * 调用sso系统的接口，获取指定token对应的用户信息
	 * @param token
	 * @return
	 */
	@Override
	public TbUser getUserByToken(String token) {
		try {
			String json = HttpClientUtil.doGet(SSO_BASE_URL+SSO_USER_SESSION_TOKEN+"/"+token);
			JSONObject taotaoResultObject = JSONObject.parseObject(json);
			if(taotaoResultObject.getString("status").equals("200")) {
				return JSONObject.parseObject(taotaoResultObject.getString("data"),TbUser.class);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSSO_BASE_URL() {
		return SSO_BASE_URL;
	}

	public String getSSO_PAGE_LOGIN() {
		return SSO_PAGE_LOGIN;
	}
}
