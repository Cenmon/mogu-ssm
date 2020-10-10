package com.mogu.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mogu.portal.service.WebAdvService;
import com.taotao.pojo.TbContent;

import taotao_utils.HttpClientUtil;

@Service
public class WebAdvServiceImpl implements WebAdvService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_ADV_URL}")
	private String REST_INDEX_AD_URL;
	@Value("${REST_INDEX_SMALL_ADV_URL}")
	private String REST_INDEX_SMALL_ADV_URL;
	
	@Override
	public String getContentAdvList() {
		// 获得首页大广告的内容列表（即cid=89）
		String list = HttpClientUtil.doGet(REST_BASE_URL+REST_INDEX_AD_URL);
//		System.out.println(list);
		try {
			// 把字符串转化为List<TbContent>
			List<TbContent> contentList = JSONObject.parseArray(list, TbContent.class);
			
			List<Map> resList = new ArrayList<>(); 
			
			for (TbContent tbContent : contentList) {
				Map map = new HashMap<>();
				map.put("src", tbContent.getPic());
				map.put("height",240);
				map.put("width",670);
				map.put("srcB",tbContent.getPic2());
				map.put("widthB",550);
				map.put("heightB",240);
				map.put("href",tbContent.getUrl());
				map.put("alt",tbContent.getTitle());
				resList.add(map);
			}
			return JSON.toJSONString(resList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("轮播页初始化失败");
		}
		return null;
	}

	@Override
	public String getContentSmallList() {
		// 获取小广告记录（cid=86）
		String json = HttpClientUtil.doGet(REST_BASE_URL+REST_INDEX_SMALL_ADV_URL);
		
		try {
			List<TbContent> list = JSONArray.parseArray(json, TbContent.class);
			
			List<Map> resList = new ArrayList<>();
			int index=0;
			for (TbContent tbContent : list) {
				Map map = new HashMap<>();
				map.put("alt",tbContent.getTitle());
				map.put("href",tbContent.getUrl());
				map.put("index",index++);
				map.put("src",tbContent.getPic().split(",")[0]);
				map.put("ext","");
				resList.add(map);
			}
			return JSON.toJSONString(resList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("小广告初始化失败");
		}
		return null;
	}

}
