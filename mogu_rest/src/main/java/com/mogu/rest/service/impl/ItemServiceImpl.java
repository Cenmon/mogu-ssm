package com.mogu.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mogu.rest.dao.JedisClient;
import com.mogu.rest.service.ItemService;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;

import taotao_common.TaotaoItemResult;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper; 
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${rest.redis.item.key}")
	private String REST_REDIS_ITEM_KEY;
	
	@Value("${rest.redis.expire.time}")
	private Integer REST_REDIS_EXPIRE_TIME;
	
	@Override
	public TaotaoItemResult getItemBaseInfo(long itemId) {

		String baseInfoKey = REST_REDIS_ITEM_KEY + ":" + itemId + ":base" ;
		
		try {
			// 获取缓存中的商品缓存信息
			String json = jedisClient.get(baseInfoKey);
			if(!StringUtils.isBlank(json)) {
				// 转化为TbItem的pojo对象
				TbItem item = JSONObject.parseObject(json, TbItem.class);
				return TaotaoItemResult.ok(item);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
		
		// 将查到的信息添加到缓存
		try {
			jedisClient.set(baseInfoKey, JSON.toJSONString(item));
			jedisClient.expire(baseInfoKey, REST_REDIS_EXPIRE_TIME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return TaotaoItemResult.ok(item);
	}

	@Override
	public TaotaoItemResult getItemDescInfo(long itemId) {
		
		String itemDescKey = REST_REDIS_ITEM_KEY + ":" + itemId + ":desc";
		
		try {
			String json = jedisClient.get(itemDescKey);
			if(!StringUtils.isBlank(json)) {
				TbItemDesc itemDesc = JSONObject.parseObject(json,TbItemDesc.class);
				return TaotaoItemResult.ok(itemDesc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbItemDesc itemDesc = tbItemDescMapper.selectByPrimaryKey(itemId);
		
		try {
			jedisClient.set(itemDescKey, JSON.toJSONString(itemDesc));
			jedisClient.expire(itemDescKey, REST_REDIS_EXPIRE_TIME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoItemResult.ok(itemDesc);
	}

	@Override
	public TaotaoItemResult getItemParamInfo(long itemId) {
		String itemParamKey = REST_REDIS_ITEM_KEY + ":" + itemId + ":param";
		
		try {
			String json = jedisClient.get(itemParamKey);
			if(!StringUtils.isBlank(json)) {
				TbItemParamItem itemParam = JSONObject.parseObject(json,TbItemParamItem.class);
				return TaotaoItemResult.ok(itemParam);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> list = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
		
		if(list!=null && list.size()!=0) {
			TbItemParamItem tbItemParamItem = list.get(0);
			try {
				jedisClient.set(itemParamKey, JSON.toJSONString(tbItemParamItem));
				jedisClient.expire(itemParamKey, REST_REDIS_EXPIRE_TIME);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return TaotaoItemResult.ok(tbItemParamItem);
		}
		return TaotaoItemResult.build(400, "无该商品规格参数");
	}
}
