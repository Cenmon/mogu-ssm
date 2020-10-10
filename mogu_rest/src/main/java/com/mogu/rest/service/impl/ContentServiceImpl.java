package com.mogu.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.mogu.rest.dao.JedisClient;
import com.mogu.rest.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${rest.index.content.jedis.sort}")
	private String REST_INDEX_CONTENT_SORT;	
	
	@Override
	public List<TbContent> getContentByCid(long cid) {
		//添加缓存处理
		try {
			String string = jedisClient.hget(REST_INDEX_CONTENT_SORT, cid+"");
			if(!StringUtils.isBlank(string)) {
				List<TbContent> list = JSONObject.parseArray(string, TbContent.class);
				return list; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list = contentMapper.selectByExample(example);
		
		try {
			String jsonString = JSON.toJSONString(list);
			jedisClient.hset(REST_INDEX_CONTENT_SORT, cid+"", jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
