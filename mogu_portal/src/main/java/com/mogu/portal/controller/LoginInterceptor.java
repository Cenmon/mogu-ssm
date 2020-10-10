package com.mogu.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mogu.portal.service.UserService;
import com.mogu.portal.service.impl.UserServiceImpl;
import com.taotao.pojo.TbUser;

import taotao_utils.CookieUtils;

public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在handler执行之前的处理
		//判断用户是否登录
		//从cookie取去token
		String token = CookieUtils.getCookieValue(request, "MG_TOKEN");
		if(StringUtils.isBlank(token)) {
			//跳转到登录页面，把用户请求的url作为参数传递给登录页面
			response.sendRedirect(userService.getSSO_BASE_URL()+userService.getSSO_PAGE_LOGIN()
			       +"?redirect="+request.getRequestURL());
			//返回false
			return false;
		}
		//根据token获取用户信息，调用sso系统服务
		TbUser user = userService.getUserByToken(token);
		//取不到用户信息
		if(user == null) {
			//跳转到登录页面，把用户请求的url作为参数传递给登录页面
			response.sendRedirect(userService.getSSO_BASE_URL()+userService.getSSO_PAGE_LOGIN()
			       +"?redirect="+request.getRequestURL());
			//返回false
			return false;
		}
		//取到用户信息，进行下一步
//		request.getSession().setAttribute("user", user);
		//返回值决定handler是否执行，true：执行，false：不执行
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//handler执行之后，返回ModelAndView之前
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//返回ModelAndView之后
		//响应用户之后
	}

}
