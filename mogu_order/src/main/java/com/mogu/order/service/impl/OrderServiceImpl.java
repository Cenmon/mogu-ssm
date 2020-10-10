package com.mogu.order.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mogu.order.dao.JedisClient;
import com.mogu.order.pojo.Order;
import com.mogu.order.service.OrderService;
import com.taotao.mapper.TbOrderItemMapper;
import com.taotao.mapper.TbOrderMapper;
import com.taotao.mapper.TbOrderShippingMapper;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderExample;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderItemExample;
import com.taotao.pojo.TbOrderItemExample.Criteria;
import com.taotao.pojo.TbOrderShipping;

import taotao_common.TaotaoItemResult;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private JedisClient jedisClient;
	
	@Autowired
	private TbOrderMapper orderMapper;
	
	@Autowired
	private TbOrderItemMapper orderItemMapper;
	
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	
	@Value("${ORDER_ID_INIT_VALUE}")
	private String ORDER_ID_INIT_VALUE;
	
	@Value("${ORDER_ID_INCR_KEY}")
	private String ORDER_ID_INCR_KEY;
	
	@Value("${ORDER_DETAIL_INCR_KEY}")
	private String ORDER_DETAIL_INCR_KEY;
	
	@Override
	public TaotaoItemResult createOrder(TbOrder order, List<TbOrderItem> orderDetailList, TbOrderShipping orderShipping) {
		
		//插入订单表
		//通过redis的incr方法获取不重复的订单编号
			//注：redis为单线程运行，即一次处理一个请求，指定订单编号初始值后，调用incr方法每次获取的值都将不同
		long orderId = jedisClient.incr(ORDER_ID_INCR_KEY);
		order.setOrderId(orderId+"");
		//设置订单状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭'
		order.setStatus(1);
		Date date = new Date();
		order.setCreateTime(date);
		order.setUpdateTime(date);
		//买主是否评价：1：评价 0：未评价
		order.setBuyerRate(0);
		orderMapper.insert(order);
		
		//插入订单详情表
		for (TbOrderItem tbOrderItem : orderDetailList) {
			//补全订单明细
			long orderDetailId = jedisClient.incr(ORDER_DETAIL_INCR_KEY);
			tbOrderItem.setId(orderDetailId+"");
			tbOrderItem.setOrderId(orderId+"");
			orderItemMapper.insert(tbOrderItem);
		}
		
		//插入物流表
		//补全物流表属性
		orderShipping.setOrderId(orderId+"");
		orderShipping.setCreated(date);
		orderShipping.setUpdated(date);
		orderShippingMapper.insert(orderShipping);
		
		return TaotaoItemResult.ok(orderId);
	}
	
	@PostConstruct
	private void initRedisOrderIdKey() {
		String orderId = jedisClient.get(ORDER_ID_INCR_KEY);
		if(StringUtils.isBlank(orderId)) {
			jedisClient.set(ORDER_ID_INCR_KEY, ORDER_ID_INIT_VALUE);
		}
	}

	/**
	 * 通过订单id获取订单信息
	 */
	@Override
	public TaotaoItemResult getOrderById(String orderId) {
		
		Order order = new Order();
		//获取商品信息
		TbOrder tbOrder = orderMapper.selectByPrimaryKey(orderId);
		order.setOrderId(tbOrder.getOrderId());
		order.setPayment(tbOrder.getPayment());
		order.setPaymentType(tbOrder.getPaymentType());
		order.setStatus(tbOrder.getStatus());
		order.setCreateTime(tbOrder.getCreateTime());
		order.setPostFee(tbOrder.getPostFee());
		order.setOrderId(tbOrder.getOrderId());
		order.setBuyerMessage(tbOrder.getBuyerMessage());
		order.setBuyerNick(tbOrder.getBuyerNick());
		
		//获取订单详情信息
		TbOrderItemExample example = new TbOrderItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<TbOrderItem> orderItemList = orderItemMapper.selectByExample(example);
		order.setOrderItems(orderItemList);
		
		//获取订单物流信息
		TbOrderShipping tbOrderShipping = orderShippingMapper.selectByPrimaryKey(orderId);
		order.setOrderShipping(tbOrderShipping);
		
		return TaotaoItemResult.ok(order);
		
	}

	/**
	 * 根据用户查询订单信息，并分页返回
	 */
	@Override
	public TaotaoItemResult getOrderByUserName(String username, Integer page, Integer rows) {
		TbOrderExample example = new TbOrderExample();
		com.taotao.pojo.TbOrderExample.Criteria criteria = example.createCriteria();
		criteria.andBuyerNickEqualTo(username);
		PageHelper.startPage(page, rows);
		List<TbOrder> list = orderMapper.selectByExample(example);
		
		return TaotaoItemResult.ok(list);
	}

	@Override
	public TaotaoItemResult updateOrderStatus(TbOrder order) {
		order.setUpdateTime(new Date());
		orderMapper.updateByPrimaryKeySelective(order);
		
		return TaotaoItemResult.ok();
	}

}
