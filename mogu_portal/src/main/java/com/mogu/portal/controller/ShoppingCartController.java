package com.mogu.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.portal.pojo.ShoppingCartItem;
import com.mogu.portal.service.ShoppingCartService;

import taotao_common.TaotaoItemResult;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping("/add/{itemId}")
	public String addCartItem(@PathVariable String itemId,
			@RequestParam(defaultValue = "1")Integer num,
			HttpServletRequest request,HttpServletResponse response) {
		shoppingCartService.addShoppingCartItem(itemId, num, request, response);
//		return "cartSuccess";
		return "redirect:/cart/add/success.html";
	}
	
	/**
	 * 购物车添加商品成功重定向的页面
	 * @return
	 */
	@RequestMapping("/add/success")
	public String addSuccess() {
		return "cartSuccess";
	}
	
	/**
	 * 修改购物车中商品数目
	 * @param itemId：修改商品的id
	 * @param count：商品数目
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/update/num/{itemId}/{count}")
	@ResponseBody
	public TaotaoItemResult updateItemCount(@PathVariable String itemId,@PathVariable int count,
			HttpServletRequest request,HttpServletResponse response) {
		return shoppingCartService.updateItemNum(itemId, count, request, response);
	}
	
	/**
	 * 删除购物车中指定商品
	 * @param itemId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delete/{itemId}")
	public String deleteCartItem(@PathVariable String itemId,
			HttpServletRequest request,HttpServletResponse response) {
		shoppingCartService.deleteShoppingCartItem(itemId, request, response);
		return "redirect:/cart/cart.html";
	}
	
	/**
	 * 展示购物车
	 * 映射到两个url：/cart/cart.html和/cart/show.html
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/cart","/show"})
	public String showShoppingCartItem(HttpServletRequest request,HttpServletResponse response,Model model) {
		List<ShoppingCartItem> list = shoppingCartService.showShoppingCartItem(request, response);
		model.addAttribute("cartList", list);
		return "cart";
	}
}
