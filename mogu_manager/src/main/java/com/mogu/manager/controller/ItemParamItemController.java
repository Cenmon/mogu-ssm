package com.mogu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.ItemParamItemService;
import com.taotao.pojo.TbItemParamItem;

@Controller
public class ItemParamItemController {
	@Autowired
	private ItemParamItemService itemParamItemService;
	
	@RequestMapping("item/param/show/{itemId}")
	public String showItemParam(@PathVariable long itemId,Model model) {
		String string = itemParamItemService.getItemParamByItemId(itemId);
		model.addAttribute("itemParam", string);
		return "item-param-show";
	}
	
	@RequestMapping("/item/param/item/query/{id}")
	@ResponseBody
	public TbItemParamItem getItemParamItemById(@PathVariable long id) {
		return itemParamItemService.getItemParamItemById(id);
	}
}
