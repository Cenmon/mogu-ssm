package com.mogu.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.ContentCatService;

import taotao_common.EUTreeNode;
import taotao_common.TaotaoItemResult;

@Controller
@RequestMapping("/content/category")
public class ContentCatController {

	@Autowired
	private ContentCatService contentCatService;
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoItemResult insertContentCat(Long parentId, String name) {
		return contentCatService.insertContentCat(parentId, name);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value = "id",defaultValue = "0")long parentId) {
		return contentCatService.getContentCatList(parentId);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoItemResult deleteContentCat(Long id) {
		return contentCatService.deleteContentCat(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoItemResult resetContentCat(Long id,String name) {
		return contentCatService.updateContentCat(id, name);
	}
}
