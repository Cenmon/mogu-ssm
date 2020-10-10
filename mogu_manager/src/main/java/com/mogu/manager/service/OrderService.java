package com.mogu.manager.service;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

public interface OrderService {
	EUDataGridResult getOrderList(int page,int rows);
	
	TaotaoItemResult deleteOrders(long[] orderIds);
}
