package com.mogu.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.search.service.SolrItemService;

import taotao_common.TaotaoItemResult;

@Controller
@RequestMapping("/manager")
public class SolrItemController {

	@Autowired
	private SolrItemService solrItemService;
	
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoItemResult importAllItems() throws Exception {
		return solrItemService.importAllItem();
	}
	
	@RequestMapping("/import/{itemId}")
	@ResponseBody
	public TaotaoItemResult importItem(@PathVariable long itemId) throws Exception {
		return solrItemService.importItem(itemId);
	}
	
	@RequestMapping("/delete/{itemId}")
	@ResponseBody
	public TaotaoItemResult deleteItem(@PathVariable long itemId) throws Exception {
		return solrItemService.deleteItem(itemId);
	}
}
