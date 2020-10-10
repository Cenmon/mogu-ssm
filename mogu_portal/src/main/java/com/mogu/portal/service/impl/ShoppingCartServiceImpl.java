package com.mogu.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mogu.portal.pojo.ShoppingCartItem;
import com.mogu.portal.service.ShoppingCartService;
import com.taotao.pojo.TbItem;

import taotao_common.TaotaoItemResult;
import taotao_utils.CookieUtils;
import taotao_utils.HttpClientUtil;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${REST_ITEM_INFO_URL}")
	private String REST_ITEM_INFO_URL;
	
	/**
	 * 购物车添加商品，通过添加cookie记录实现
	 */
	@Override
	public TaotaoItemResult addShoppingCartItem(String itemId,Integer count, HttpServletRequest request,
			HttpServletResponse response) {
		ShoppingCartItem cartItem = new ShoppingCartItem();
		cartItem.setId(itemId);
		List<ShoppingCartItem> CartList = getShoppingCartList(request);
		//添加到购物车
		CartList.add(cartItem);
		
		//哨兵顺序查找
		int index = 0;
		for(;!CartList.get(index).getId().equals(itemId);index++);
		
		if(index == CartList.size()-1) { //若匹配至list尾，即原购物车中无该商品
			try {
				String json = HttpClientUtil.doGet(REST_BASE_URL+REST_ITEM_INFO_URL+"/"+itemId);
//				System.out.println(url);
//				System.out.println("itemInfo:"+json);
				if(json != null) {
					JSONObject parseObject = JSONObject.parseObject(json);
//					System.out.println(parseObject.getString("status").getClass());
					if(parseObject.getString("status").equals("200")) {
						TbItem item = JSONObject.parseObject(parseObject.getString("data"),TbItem.class);
						cartItem.setImage(item.getImage()==null? "" :item.getImage().split(",")[0]);
						cartItem.setPrice(item.getPrice());
						cartItem.setTitle(item.getTitle());
						cartItem.setCount(count);
					}					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			// 若已有该商品，则商品数目加一
			ShoppingCartItem item = CartList.get(index);
			item.setCount(item.getCount()+count);
		}
		//把购物车列表写入cookie
		CookieUtils.setCookie(request, response, "MG_CART", JSONObject.toJSONString(CartList,SerializerFeature.WriteMapNullValue),true);
		
		return TaotaoItemResult.ok();
	}
	
	/**
	 * 读取cookie中的购物车商品列表
	 */
	public List<ShoppingCartItem> getShoppingCartList(HttpServletRequest request){
		String CartListjson = CookieUtils.getCookieValue(request, "MG_CART", true);
//		System.out.println("CartListjson:"+CartListjson);
		if(CartListjson == null) {
			return new ArrayList<>();
		}
		
		try {
			List<ShoppingCartItem> list = JSONObject.parseArray(CartListjson, ShoppingCartItem.class);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	/**
	 * 展示购物车
	 */
	@Override
	public List<ShoppingCartItem> showShoppingCartItem(HttpServletRequest request, HttpServletResponse response) {
		return getShoppingCartList(request);
	}

	/**
	 * 修改购物车中的商品数量
	 */
	@Override
	public TaotaoItemResult updateItemNum(String itemId, int count, HttpServletRequest request,
			HttpServletResponse response) {
		List<ShoppingCartItem> cartList = getShoppingCartList(request);
		
		for (ShoppingCartItem shoppingCartItem : cartList) {
			if(shoppingCartItem.getId().equals(itemId)) {
				shoppingCartItem.setCount(count);
			}
		}
		
		//写入cookie
		CookieUtils.setCookie(request, response, "MG_CART", JSONObject.toJSONString(cartList,SerializerFeature.WriteMapNullValue), true);
		
		return TaotaoItemResult.ok();
	}

	/**
	 * 删除购物车中的商品
	 */
	@Override
	public TaotaoItemResult deleteShoppingCartItem(String itemId, HttpServletRequest request,
			HttpServletResponse response) {
		List<ShoppingCartItem> cartList = getShoppingCartList(request);
		
		try {
			int index=cartList.size()-1;
			for(;!cartList.get(index).getId().equals(itemId);index--);
			cartList.remove(index);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("非法删除！未在购物车中选定商品删除");
		}
		
		//写入cookie
		CookieUtils.setCookie(request, response, "MG_CART", JSONObject.toJSONString(cartList,SerializerFeature.WriteMapNullValue), true);
		return TaotaoItemResult.ok();
	}

	/*
	 * 清空购物车
	 */
	@Override
	public TaotaoItemResult clearShoppingCart(HttpServletRequest request,HttpServletResponse response) {
		try {
			CookieUtils.setCookie(request, response, "MG_CART", "", true);
			return TaotaoItemResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoItemResult.build(500, "清空购物车失败！");
	}
}
