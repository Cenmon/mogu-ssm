package com.mogu.manager.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParam;

import taotao_common.TaotaoItemResult;
import taotao_common.EUDataGridResult;

public interface ItemService {
	TbItem getItemById(long itemId); // 根据id查询，单表查询，无法分页
	
	EUDataGridResult getItemList(int page,int rows); // 查询商品，分页查询
	
	TaotaoItemResult AddItem(TbItem item,TbItemDesc tbItemDesc,String itemParam) throws Exception;
	
	TaotaoItemResult AddItemDesc(long itemId,TbItemDesc itemDesc);
	
	TaotaoItemResult AddItemParam(long itemId,String itemParam);
	
	TaotaoItemResult DeleteItem(long[] ids);
	
	TaotaoItemResult InstockItem(long[] ids);
	
	TaotaoItemResult ReshelfItem(long[] ids);
	
	TaotaoItemResult UpdateItem(TbItem item);
}
