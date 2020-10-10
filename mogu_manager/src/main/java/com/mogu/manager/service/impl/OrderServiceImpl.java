package com.mogu.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogu.manager.service.OrderService;
import com.taotao.mapper.TbOrderListMapper;
import com.taotao.pojo.TbListOrder;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderListMapper orderListMapper;
	
	@Override
	public EUDataGridResult getOrderList(int page, int rows) {
		//自定义mapper.xml，获取所需的orderList
		PageHelper.startPage(page, rows);
		List<TbListOrder> list = orderListMapper.selectByOrderId();
		
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		PageInfo<TbListOrder> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoItemResult deleteOrders(long[] orderIds) {
		for (long orderId : orderIds) {
			orderListMapper.deleteOrderById(orderId);
		}
		return TaotaoItemResult.ok();
	}

}
