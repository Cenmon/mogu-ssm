package com.mogu.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogu.manager.service.ItemCatService;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;

import taotao_common.EUTreeNode;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EUTreeNode> getItemCatList(long parentID) {
		// 创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria(); // Criteria是一个内部类
		criteria.andParentIdEqualTo(parentID);
		
		//根据查询条件查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		// 将查询结果转化为EUTreeNode返回客户端
		List<EUTreeNode> resEuTreeNodes = new ArrayList<>();
		for(TbItemCat tbItemCat:list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
//			System.out.println(tbItemCat.getParentId());
			resEuTreeNodes.add(node);
		}
		//返回结果
		return resEuTreeNodes;
	}

	@Override
	public TbItemCat getTbItemCatById(long id) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
