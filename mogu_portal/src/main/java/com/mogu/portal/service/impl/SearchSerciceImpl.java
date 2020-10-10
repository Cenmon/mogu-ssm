package com.mogu.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mogu.portal.pojo.SearchResult;
import com.mogu.portal.service.SearchService;

import taotao_common.TaotaoItemResult;
import taotao_utils.HttpClientUtil;

@Service
public class SearchSerciceImpl implements SearchService {
	
	@Value("${SEARCH_ADDRESS}")
	private String SEARCH_ADDRESS;
	
	@Override
	public SearchResult search(String queryString, Integer page) {
		Map<String, String> map = new HashMap<>();
		map.put("q", queryString);
		map.put("page",page+"");
		try {
			String json = HttpClientUtil.doGet(SEARCH_ADDRESS,map);
//			System.out.println(json);
			JSONObject jsonObject = JSONObject.parseObject(json);
			if(jsonObject.getString("status").equals("200")) {
				return JSONObject.parseObject(jsonObject.getString("data"), SearchResult.class);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
