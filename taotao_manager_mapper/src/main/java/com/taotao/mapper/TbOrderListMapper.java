package com.taotao.mapper;

import java.util.List;

import com.taotao.pojo.TbListOrder;

public interface TbOrderListMapper {
	public List<TbListOrder> selectByOrderId();
	
	public int deleteOrderById(long orderId);
}
