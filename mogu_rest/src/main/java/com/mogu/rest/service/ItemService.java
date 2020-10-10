package com.mogu.rest.service;

import taotao_common.TaotaoItemResult;

public interface ItemService {
	TaotaoItemResult getItemBaseInfo(long itemId);
	
	TaotaoItemResult getItemDescInfo(long itemId);
	
	TaotaoItemResult getItemParamInfo(long itemId);
}
