package com.mogu.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.pojo.TbUser;

import taotao_common.TaotaoItemResult;

public interface UserService {
	TaotaoItemResult checkLoginData(String param,Integer type);
	
	TaotaoItemResult register(TbUser user);
	
	TaotaoItemResult login(String username,String password,HttpServletRequest request,HttpServletResponse response);
	
	TaotaoItemResult getUserByToken(String token);
	
	TaotaoItemResult deleteUserByToken(String token,HttpServletRequest request,HttpServletResponse response);
}
