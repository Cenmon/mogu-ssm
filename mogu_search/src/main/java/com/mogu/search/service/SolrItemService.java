package com.mogu.search.service;

import taotao_common.TaotaoItemResult;

public interface SolrItemService {
	TaotaoItemResult importAllItem() throws Exception;
	
	TaotaoItemResult importItem(long id) throws Exception;
	
	TaotaoItemResult deleteItem(long id) throws Exception;
}
