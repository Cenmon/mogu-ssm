package com.mogu.portal.controller;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.portal.pojo.SearchResult;
import com.mogu.portal.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/search")
	public String search(@RequestParam("q")String queryString,@RequestParam(defaultValue = "1")Integer page,Model model) {
//		System.out.println(queryString);
		try {
			if(!StringUtils.isBlank(queryString)) {				
				queryString = new String(queryString.getBytes("ISO8859-1"),"utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		System.out.println("转换后："+queryString);
		SearchResult search = searchService.search(queryString, page);
		model.addAttribute("query", queryString);
		model.addAttribute("totalPages", search.getPageCount()  );
		model.addAttribute("itemList", search.getItemList());
		model.addAttribute("page", page);
		return "search";
	}
}
