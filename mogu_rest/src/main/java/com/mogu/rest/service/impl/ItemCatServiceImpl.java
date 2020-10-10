package com.mogu.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mogu.rest.dao.JedisClient;
import com.mogu.rest.pojo.CatNode;
import com.mogu.rest.pojo.CatResult;
import com.mogu.rest.service.ItemCatService;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${rest.index.item.cat.jedis.sort}")
	private String REST_INDEX_ITEM_CAT_SORT;
	
	@Override
	public CatResult getItemCatList() {
		try {
			String string = jedisClient.hget(REST_INDEX_ITEM_CAT_SORT, "itemCatList");
			if(!StringUtils.isBlank(string)) {
				return JSONObject.parseObject(string, CatResult.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0).subList(0, 14));
		
		try {
			String jsonString = JSON.toJSONString(catResult);
//			System.out.println(jsonString);
			jedisClient.hset(REST_INDEX_ITEM_CAT_SORT, "itemCatList", jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catResult;
	}

	private List<?> getCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		List resList = new ArrayList<>();
		for(TbItemCat tbItemCat:list) {
			if(!tbItemCat.getIsParent()) {
				resList.add("/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName());
				continue;
			}
			
			CatNode catNode = new CatNode();
			if(parentId == 0) {
				catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");		
			}
			else {
				catNode.setName(tbItemCat.getName());
			}
			
			catNode.setUrl("/products/"+tbItemCat.getId()+".html");
			catNode.setItem(getCatList(tbItemCat.getId()));
			resList.add(catNode);
		}
		return resList;
	}

}
