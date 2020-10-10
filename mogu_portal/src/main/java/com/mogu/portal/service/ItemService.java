package com.mogu.portal.service;

import com.mogu.portal.pojo.ItemInfo;

public interface ItemService {
	ItemInfo getItemBaseInfoById(long itemId);
	
	String getItemDescInfoById(long itemId);
	
	String getItemParamInfoById(long itemId);
}
