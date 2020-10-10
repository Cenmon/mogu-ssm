package com.mogu.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mogu.portal.pojo.Order;
import com.mogu.portal.pojo.ShoppingCartItem;
import com.mogu.portal.service.OrderService;
import com.mogu.portal.service.impl.ShoppingCartServiceImpl;
import com.taotao.pojo.TbUser;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ShoppingCartServiceImpl shoppingCartService;
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 展示订单结算页面:显示已购购物车，结算金额等等
	 * @return
	 */
	@RequestMapping("/order-cart")
	public String showOrderCount(HttpServletRequest request,HttpServletResponse response,Model model) {
		List<ShoppingCartItem> list = shoppingCartService.getShoppingCartList(request);
		model.addAttribute("cartList", list);
		return "order-cart";
	}
	
	/**
	 * 前台创建订单
	 * @param order
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public String createOrder(Order order,Model model,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			//补全order对象
//			TbUser user = (TbUser)request.getSession().getAttribute("user");
//			order.setUserId(user.getId());
//			order.setBuyerNick(user.getUsername());
			//创建订单
			String orderId = orderService.createOrder(order);
			model.addAttribute("orderId", orderId);
			model.addAttribute("payment", order.getPayment());
			model.addAttribute("date",new DateTime().plusDays(3).toString("yyyy-MM-dd") );
			//清空购物车
			shoppingCartService.clearShoppingCart(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "订单创建失败！");
			return "/error/exception";
		}
		return "success";
	}
}
