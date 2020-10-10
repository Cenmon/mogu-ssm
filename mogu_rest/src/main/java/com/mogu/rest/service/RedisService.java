package com.mogu.rest.service;

import taotao_common.TaotaoItemResult;

public interface RedisService {
	TaotaoItemResult syncContent(long cid);
	
	TaotaoItemResult syncItemCat();
}
