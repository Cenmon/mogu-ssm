package com.mogu.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.portal.service.WebAdvService;

@Controller
public class PageController {
	
	@Autowired
	private WebAdvService advService;
	
	@RequestMapping("/index")
	public String showIndex(Model model){
		String bigAdvString = advService.getContentAdvList();
		String smallAdvString = advService.getContentSmallList();
		model.addAttribute("ad1", bigAdvString);
		model.addAttribute("ad2",smallAdvString);
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
