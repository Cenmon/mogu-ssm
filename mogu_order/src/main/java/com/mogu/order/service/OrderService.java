package com.mogu.order.service;

import java.util.Date;
import java.util.List;

import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

import taotao_common.TaotaoItemResult;

public interface OrderService {
	
	TaotaoItemResult createOrder(TbOrder order,List<TbOrderItem> orderDetailList,TbOrderShipping orderShipping);
	
	TaotaoItemResult getOrderById(String orderId);
	
	TaotaoItemResult getOrderByUserName(String username,Integer page,Integer rows);
	
	TaotaoItemResult updateOrderStatus(TbOrder order);
}
