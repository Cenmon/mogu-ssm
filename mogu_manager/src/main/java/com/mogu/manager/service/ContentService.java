package com.mogu.manager.service;

import com.taotao.pojo.TbContent;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

public interface ContentService {
	EUDataGridResult getContentList(Long categoryId,int page,int rows);
	
	TaotaoItemResult insertContent(TbContent content);
	
	TaotaoItemResult deleteContent(long id);
	
	TaotaoItemResult editContent(TbContent content);
}
