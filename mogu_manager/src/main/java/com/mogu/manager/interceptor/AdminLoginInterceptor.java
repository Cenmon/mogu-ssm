package com.mogu.manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mogu.manager.service.AdminService;
import com.taotao.pojo.TbAdmin;

import taotao_utils.CookieUtils;

public class AdminLoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("--拦截--");
		//在handler执行之前的处理
		//判断用户是否登录
		//从cookie取去token
		String token = CookieUtils.getCookieValue(request, "MG_ADMIN");
		if(StringUtils.isBlank(token)) {
			//跳转到登录页面，把用户请求的url作为参数传递给登录页面
			response.sendRedirect("http://localhost:8080/admin/showLogin");
			//返回false
			return false;
		}
		//根据token获取用户信息，调用sso系统服务
		TbAdmin admin = adminService.getAdminByToken(token);
		//取不到用户信息
		if(admin == null) {
			//跳转到登录页面，把用户请求的url作为参数传递给登录页面.
			response.sendRedirect("http://localhost:8080/admin/showLogin");
			//返回false
			return false;
		}
		//将用户信息存入request，供后天系统获取当前用户信息
		if(request.getAttribute("admin")==null) {
			request.setAttribute("admin", admin);
		}
		//取到用户信息，进行下一步
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
