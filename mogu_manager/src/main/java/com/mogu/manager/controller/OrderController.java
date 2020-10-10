package com.mogu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.OrderService;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;
import taotao_utils.ExceptionUtil;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/list")
	@ResponseBody
	public EUDataGridResult getOrderList(long page,long rows) {
		return orderService.getOrderList((int)page, (int)rows);
	}
	
	@RequestMapping("/order/delete")
	@ResponseBody
	public TaotaoItemResult deleteOrder(long[] ids) {
		try {
			orderService.deleteOrders(ids);
			return TaotaoItemResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500,ExceptionUtil.getStackTrace(e));
		}
	}
}
