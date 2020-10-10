package com.mogu.httpclient;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
	
	public static final <T>List<T> JsonToList(String json,Class<T> beanType){
		try {
			return JSONArray.parseArray(json, beanType);
		} catch (Exception e) {
			System.out.println("JsonUtils:Failed to JsonToList.");
		}
		return null;
	}
	
	public static final String ToJson(Object obj) {
		try {
			return JSON.toJSONString(obj);
		}catch (Exception e) {
			System.out.println("JsonUtils:Failed to ToJson.");
		}
		return null;
	}
}
