package com.mogu.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mogu.portal.pojo.Order;
import com.mogu.portal.service.OrderService;

import taotao_utils.HttpClientUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	
	
	/**
	 * 前台创建订单：调用订单系统的服务接口，完成订单创建功能
	 */
	@Override
	public String createOrder(Order order) {
		
		//调用mogu_order的服务接口，提交订单
		try {			
			String json = HttpClientUtil.doPostJson(ORDER_BASE_URL+ORDER_CREATE_URL, JSON.toJSONString(order));
			JSONObject parseObject = JSONObject.parseObject(json);
			if(parseObject.getString("status").equals("200")) {
				return parseObject.getString("data");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

}
