package com.mogu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.ItemService;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	// 浏览器url带有该格式，则返回相应的itemId的item
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		// 传入的url会自带参数
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoItemResult addItem(TbItem item,String desc,String itemParams) throws Exception {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemDesc(desc);
		TaotaoItemResult result = itemService.AddItem(item, itemDesc,itemParams);
		// 更新solr索引库
//		System.out.println(SEARCH_BASE_URL+SEARCH_IMPORT_ITEM_URL);
//		HttpClientUtil.doGet(SEARCH_BASE_URL+"/"+SEARCH_IMPORT_ITEM_URL+"/"+item.getId());
		return result;
	}
	
	@RequestMapping("/item/delete")
	@ResponseBody
	public TaotaoItemResult deleteItem(long[] ids) {
		try {
			
			// 更新solr索引库
//			HttpClientUtil.doGet(SEARCH_BASE_URL+SEARCH_DELETE_ITEM_URL+"/"+id);
			return itemService.DeleteItem(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, "删除商品失败");
		}
	}
	
	@RequestMapping("/item/instock")
	@ResponseBody
	public TaotaoItemResult instockItem(long[] ids) {
		try {
			return itemService.InstockItem(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, "上架商品失败");
		}
	}
	
	@RequestMapping("/item/reshelf")
	@ResponseBody
	public TaotaoItemResult reshelfItem(long[] ids) {
		try {
			return itemService.ReshelfItem(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, "下架商品失败");
		}
	}
	
	@RequestMapping("/item/update")
	@ResponseBody
	public TaotaoItemResult updateItem(TbItem item,String desc,String itemParams) throws Exception{
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemDesc(desc);
		TaotaoItemResult result = itemService.AddItem(item, itemDesc,itemParams);
		// 更新solr索引库
//		HttpClientUtil.doGet(SEARCH_BASE_URL+SEARCH_IMPORT_ITEM_URL+"/"+item.getId());
		return result;
	}
}
