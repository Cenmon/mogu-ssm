package com.mogu.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.dao.JedisClient;
import com.mogu.manager.service.AdminService;
import com.taotao.pojo.TbAdmin;

import taotao_common.TaotaoItemResult;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Value("${REDIS_ADMIN_TOKEN}")
	private String REDIS_ADMIN_TOKEN;
	
	@Value("${REDIS_ADMIN_SESSION_KEY}")
	private String REDIS_ADMIN_SESSION_KEY;
	
	
	/**
	 * 展示修改资料页面
	 */
	@RequestMapping("/modify")
	public String showpage(Model model,HttpServletRequest request) {
		TbAdmin admin = (TbAdmin)request.getAttribute("admin");
		model.addAttribute("admin", admin);
		return "admin-edit";
	}
	
	/**
	 * 管理员登录界面
	 * @param redirect
	 * @param model
	 * @return
	 */
	@RequestMapping("/showLogin")
	public String showAdminLogin() {
		return "adminLogin";
	}
	
	/**
	 * 根据类型验证数据是否存在
	 * @param param
	 * @param type
	 * @return
	 */
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public TaotaoItemResult checkAdminData(@PathVariable String param,@PathVariable Integer type) {
		try {
//			System.out.println(param);
			param = new String(param.getBytes("ISO8859-1"),"utf-8");
			return adminService.checkAdminData(param, type);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, "系统错误");
		}
	}
		
	/**
	 * 修改管理员信息
	 */
	@RequestMapping(value = "/update/data",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoItemResult updateAdmin(TbAdmin admin) {
//		System.out.println(admin.getUsername());
//		System.out.println(admin.getImg());
//		System.out.println(admin.getPhone());
		return adminService.updateAdmin(admin);
	}
	
	/**
	 * 修改管理员密码
	 * @param password
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoItemResult updateAdminPassword(String old,String news,HttpServletRequest request,
			HttpServletResponse response,Model model) {
		try {
			//修改密码
			TaotaoItemResult result = adminService.updateAdminPassword(old,news,request,response);
			if(result.getStatus() == 200) {
				return TaotaoItemResult.ok("/admin/showLogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoItemResult.build(500, "修改密码失败！");
	}
	
	/**
	 * 管理员退出
	 * @return
	 */
	@RequestMapping(value = "/quit")
	@ResponseBody
	public TaotaoItemResult quitAdmin(HttpServletRequest request,HttpServletResponse response,Model model) {
		try {
			// 一台电脑只能有一个token，即一个管理员登录
			TaotaoItemResult result = adminService.deleteAdmin(request,response);
			if(result.getStatus() == 200) {
				return TaotaoItemResult.ok("/admin/showLogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoItemResult.build(500, "退出失败！");
		
	}
	
	
	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoItemResult adminLogin(String username,String password,
			HttpServletRequest request,HttpServletResponse response) {
		try {
//			System.out.println(username);
//			System.out.println(password);
			return adminService.login(username, password,request,response);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, "系统错误");
		}
	}
	
//	/**
//	 * 根据类型修改管理员信息
//	 * @param adminId
//	 * @param param
//	 * @param type
//	 * @return
//	 */
//	@RequestMapping(value = "/update/data/{old}/{news}/{type}",method = RequestMethod.POST)
//	@ResponseBody
//	public TaotaoItemResult updateAdminData(@PathVariable String old,
//			@PathVariable String news,@PathVariable Integer type) {
//		try {
//			//根据数据类型更新数据
//			//数据类型：1：用户名 2：电子邮箱 3：手机号
//			System.out.println(old);
//			System.out.println(news);
//			old = new String(old.getBytes("ISO8859-1"),"utf-8");
//			news = new String(news.getBytes("ISO8859-1"),"utf-8");
//			adminService.updateAdminByType(old,news, type);
//			return TaotaoItemResult.ok();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return TaotaoItemResult.build(500, "更新失败");
//		}
//	}
}
