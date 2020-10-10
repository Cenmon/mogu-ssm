package com.mogu.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.order.pojo.Order;
import com.mogu.order.service.OrderService;
import com.taotao.pojo.TbOrder;

import taotao_common.TaotaoItemResult;
import taotao_utils.ExceptionUtil;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 创建订单
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoItemResult createOrder(@RequestBody Order order) {
		try {
			return orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 通过订单id获取订单信息
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/info/{orderId}")
	@ResponseBody
	public TaotaoItemResult getOrderById(@PathVariable String orderId) {
		return orderService.getOrderById(orderId);
	}
	
	/**
	 * 根据用户名查询订单信息，并分页显示
	 * @param userId
	 * @param page
	 * @param count
	 * @return
	 */
	@RequestMapping("/list/{username}/{page}/{count}")
	@ResponseBody
	public TaotaoItemResult getOrderByUserId(@PathVariable String username,
			@PathVariable Integer page,@PathVariable Integer count) {
		try {
//			System.out.println(username);
//			username = new String(username.getBytes("ISO8859-1"),"utf-8");
//			System.out.println(username);
			return orderService.getOrderByUserName(username, page, count);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	/**
	 * 修改订单状态
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/changeStatus",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoItemResult updateOrderStatus(@RequestBody TbOrder order) {
		return orderService.updateOrderStatus(order);
	}
}
