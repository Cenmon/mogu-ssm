package com.mogu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mogu.rest.pojo.CatResult;
import com.mogu.rest.service.ItemCatService;

import taotao_utils.JsonUtils;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		CatResult catResult = itemCatService.getItemCatList();
		
		String json = JSON.toJSONString(catResult);
		String resultString = callback+"("+json+");";
//		System.out.println(resultString);
		return resultString;
	}
	
//	@RequestMapping("/{page}")
//	public String pageshow(@PathVariable String page) {
//		return page;
//	}
}
