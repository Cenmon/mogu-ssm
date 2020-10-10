package com.mogu.manager.service;

import java.util.List;

import com.taotao.pojo.TbItemCat;

import taotao_common.EUTreeNode;

public interface ItemCatService {
	List<EUTreeNode> getItemCatList(long parentID);
	
	TbItemCat getTbItemCatById(long id);
}
