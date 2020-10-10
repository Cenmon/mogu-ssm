package com.mogu.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.ItemCatService;

import taotao_common.EUTreeNode;

@Controller
//@RequestMapping("item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@Value("${rest.baseUrl}")
	private String REST_BASEURL;
	
	@Value("${rest.itemCat.sync.url}")
	private String REST_ITEMCAT_SYNC_URL;
	
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<EUTreeNode> getCatList(@RequestParam(value = "id",defaultValue = "0")long parentId){
		// 此方法的访问修饰符为public
//		System.out.println(parentId);
		List<EUTreeNode> list = itemCatService.getItemCatList(parentId);
//		for(EUTreeNode node : list) {
//			System.out.println(node.getState());
//		}
		return list;
//		return itemCatService.getItemCatList(parentId);
	}
	
}
