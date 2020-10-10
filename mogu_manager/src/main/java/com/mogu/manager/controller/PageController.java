package com.mogu.manager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.mapper.TbAdminMapper;
import com.taotao.pojo.TbAdmin;

@Controller
public class PageController {
	
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex(Model model,HttpServletRequest request) {
		TbAdmin admin = (TbAdmin)request.getAttribute("admin");
		model.addAttribute("admin", admin);
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
}
