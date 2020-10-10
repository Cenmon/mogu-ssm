package com.mogu.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mogu.portal.pojo.ShoppingCartItem;

import taotao_common.TaotaoItemResult;

public interface ShoppingCartService {
	TaotaoItemResult addShoppingCartItem(String itemId,Integer count, HttpServletRequest request,HttpServletResponse response);
	
	List<ShoppingCartItem> showShoppingCartItem(HttpServletRequest request,HttpServletResponse response);
	
	TaotaoItemResult updateItemNum(String itemId,int count,HttpServletRequest request,HttpServletResponse response);
	
	TaotaoItemResult deleteShoppingCartItem(String itemId,HttpServletRequest request,HttpServletResponse response);
	
	TaotaoItemResult clearShoppingCart(HttpServletRequest request,HttpServletResponse response);
}
