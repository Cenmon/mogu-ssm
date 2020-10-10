package com.mogu.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mogu.portal.pojo.ItemInfo;
import com.mogu.portal.service.ItemService;
import com.taotao.pojo.TbItem;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	public String getItemBaseInfoById(@PathVariable long itemId,Model model) {
		ItemInfo itemInfo = itemService.getItemBaseInfoById(itemId);
		model.addAttribute("item", itemInfo);
		return "item";
	}
	
	@RequestMapping(value="/item/desc/{itemId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String getItemDescInfoById(@PathVariable long itemId) {
		// 汉字乱码问题：produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8"
		return itemService.getItemDescInfoById(itemId);
	}
	
	@RequestMapping(value="/item/param/{itemId}",produces="text/html;charset=utf-8")
	@ResponseBody
	public String getItemParamInfoById(@PathVariable long itemId) {
		return itemService.getItemParamInfoById(itemId);
	}
}
