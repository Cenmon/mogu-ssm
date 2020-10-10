package com.mogu.manager.service;

import com.taotao.pojo.TbItemParam;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

public interface ItemParamService {
	TaotaoItemResult getItemParamByCid(long cid);
	
	TaotaoItemResult insertItemParam(TbItemParam itemParam);
	
	EUDataGridResult getItemParamList(int page,int rows);
	
	TaotaoItemResult deleteItemParam(long ids);
}
