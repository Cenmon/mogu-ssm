package com.mogu.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import taotao_common.EUDataGridResult;
import taotao_common.EUTreeNode;
import taotao_common.TaotaoItemResult;

@Service
public interface ContentCatService {
	List<EUTreeNode> getContentCatList(long parentId);
	
	TaotaoItemResult insertContentCat(long parentId,String name);
	
	TaotaoItemResult deleteContentCat(long id);
	
	TaotaoItemResult updateContentCat(long id,String name);
}
