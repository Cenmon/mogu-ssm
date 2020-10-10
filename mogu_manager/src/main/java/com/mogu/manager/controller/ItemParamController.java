package com.mogu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.ItemParamService;
import com.taotao.pojo.TbItemParam;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoItemResult getItemParamByCid(@PathVariable long itemCatId) {
		// 根据商品类别cid查询规格参数模板
		return itemParamService.getItemParamByCid(itemCatId);
	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoItemResult insertItemParam(@PathVariable long cid,String paramData) {
		// 保存商品规格参数
		TbItemParam itemParam = new TbItemParam();
		// 参数模板id自增长,故无需添加
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		return itemParamService.insertItemParam(itemParam);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemParamList(Integer page,Integer rows) {
		EUDataGridResult result = itemParamService.getItemParamList(page, rows);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoItemResult deleteItemParam(long[] ids) {
		for(long id:ids) {
			if(itemParamService.deleteItemParam(id).getStatus()!=200) {
				return TaotaoItemResult.error();
			}
		}
		return TaotaoItemResult.ok();
	}
}
