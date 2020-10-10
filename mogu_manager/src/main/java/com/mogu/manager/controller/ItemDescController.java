package com.mogu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.ItemDescService;
import com.taotao.pojo.TbItemDesc;

@Controller
public class ItemDescController {
	@Autowired
	private ItemDescService itemDescService;
	
	@RequestMapping("/item/query/item/desc/{id}")
	@ResponseBody
	public TbItemDesc getItemDescById(@PathVariable long id) {
		return itemDescService.getItemDescById(id);
	}
}
