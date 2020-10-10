package com.mogu.sso.controller;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mogu.sso.service.UserService;
import com.taotao.pojo.TbUser;

import taotao_common.TaotaoItemResult;
import taotao_utils.ExceptionUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/check/{param}/{type}")
	@ResponseBody
	public Object CheckLoginData(@PathVariable String param,@PathVariable Integer type,String callback) {
		// url中的中文转码
		try {
			param = new String(param.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		// 若param或type为空，则无法映射到该方法
		TaotaoItemResult result = null;
		if(type < 1 || type > 3) {
			result = TaotaoItemResult.build(400, "校验内容类型错误");
		}else {
			try {
				result = userService.checkLoginData(param, type);				
			} catch (Exception e) {
				e.printStackTrace();
				result = TaotaoItemResult.build(500, ExceptionUtil.getStackTrace(e));
			}
		}
		
//		String jsonString = JSONObject.toJSONString(result,SerializerFeature.WriteMapNullValue);
//		System.out.println(jsonString);
		if(StringUtils.isBlank(callback)) {
			return result;
		}else {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
	}

	@RequestMapping(value="/register",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoItemResult registerUser(TbUser user) {
		try {
			return userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(400, "注册失败, 请校验数据后请再提交数据.");
		}
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoItemResult loginUser(String username,String password,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			//post请求，封存在表单中的内容，影响不大
//			username = new String(username.getBytes("ISO8859-1"),"utf-8");
//			System.out.println(username);
			return userService.login(username, password,request,response);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping(value="/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token,String callback) {
		try {
			TaotaoItemResult result = userService.getUserByToken(token);
			if(StringUtils.isBlank(callback)) {
				return result;
			}else {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping(value="/logout/{token}")
	@ResponseBody
	public Object logout(@PathVariable String token,String callback,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			TaotaoItemResult result = userService.deleteUserByToken(token,request,response);
			if(StringUtils.isBlank(callback)) {
				return result;
			}else {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
