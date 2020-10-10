package com.mogu.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mogu.rest.dao.JedisClient;
import com.mogu.rest.service.RedisService;

import taotao_common.TaotaoItemResult;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${rest.index.content.jedis.sort}")
	private String REST_INDEX_CONTENT_SORT;
	
	@Value("${rest.index.item.cat.jedis.sort}")
	private String REST_INDEX_ITEM_CAT_SORT;
	
	@Override
	public TaotaoItemResult syncContent(long cid) {
		try {
			jedisClient.hdel(REST_INDEX_CONTENT_SORT, cid+"");
		} catch (Exception e) {
			TaotaoItemResult.error();
		}
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult syncItemCat() {
		try {
			jedisClient.hdel(REST_INDEX_ITEM_CAT_SORT, "itemCatList");
		} catch (Exception e) {
			TaotaoItemResult.error();
		}
		return TaotaoItemResult.ok();
	}

}
