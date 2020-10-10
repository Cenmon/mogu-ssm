package com.mogu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.rest.service.ItemService;

import taotao_common.TaotaoItemResult;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public TaotaoItemResult getItemBaseInfo(@PathVariable long itemId) {
		return itemService.getItemBaseInfo(itemId);
	}
	
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public TaotaoItemResult getItemDescInfo(@PathVariable long itemId) {
		return itemService.getItemDescInfo(itemId);
	}
	
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public TaotaoItemResult getItemParamInfo(@PathVariable long itemId) {
		return itemService.getItemParamInfo(itemId);
	}
	
}
