package com.mogu.manager.service;

import com.taotao.pojo.TbItemParamItem;

public interface ItemParamItemService {
	// 通过商品id获取规格参数的html代码
	String getItemParamByItemId(long itemId);
	
	TbItemParamItem getItemParamItemById(long id);
}
