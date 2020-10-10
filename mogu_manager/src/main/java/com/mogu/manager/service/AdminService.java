package com.mogu.manager.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.pojo.TbAdmin;

import taotao_common.TaotaoItemResult;

public interface AdminService {
	
//	TaotaoItemResult updateAdminByType(String old,String news,Integer type);
	
	TaotaoItemResult updateAdmin(TbAdmin admin);
	
	TaotaoItemResult checkAdminData(String param,Integer type);
	
	TaotaoItemResult login(String username,String password,HttpServletRequest request,HttpServletResponse response);
	
	TbAdmin getAdminByToken(String token);
	
	TaotaoItemResult deleteAdmin(HttpServletRequest request,HttpServletResponse response);
	
	TaotaoItemResult updateAdminPassword(String old,String news,HttpServletRequest request,HttpServletResponse response);
}
