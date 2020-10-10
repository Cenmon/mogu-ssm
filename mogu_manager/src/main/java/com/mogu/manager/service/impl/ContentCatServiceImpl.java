package com.mogu.manager.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogu.manager.service.ContentCatService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;

import taotao_common.EUTreeNode;
import taotao_common.TaotaoItemResult;

@Service
public class ContentCatServiceImpl implements ContentCatService {
	
	@Autowired
	private TbContentCategoryMapper contentCatMapper;
	
	@Override
	public List<EUTreeNode> getContentCatList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		//根据查询条件查询
		List<TbContentCategory> list = contentCatMapper.selectByExample(example);
		// 将查询结果转化为EUTreeNode返回客户端
		List<EUTreeNode> resEuTreeNodes = new ArrayList<>();
		for(TbContentCategory tbContentCat:list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCat.getId());
			node.setText(tbContentCat.getName());
			node.setState(tbContentCat.getIsParent()?"closed":"open");
			resEuTreeNodes.add(node);
		}
		//返回结果
		return resEuTreeNodes;
	}

	@Override
	public TaotaoItemResult insertContentCat(long parentId,String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		contentCategory.setStatus(1);//'状态。可选值:1(正常),2(删除)',
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());

		contentCatMapper.insert(contentCategory);// mybatis主键返回：插入记录后主键自动返回，即contentCategory的id属性自动补全
		
		// 若父节点为叶子节点，则添加节点后为非叶子节点
		TbContentCategory parentCat = contentCatMapper.selectByPrimaryKey(parentId);
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			contentCatMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoItemResult.ok(contentCategory);
	}

	@Override
	public TaotaoItemResult deleteContentCat(long id) {
		TbContentCategory contentCategory = contentCatMapper.selectByPrimaryKey(id);
		long parentId = contentCategory.getParentId();
		contentCatMapper.deleteByPrimaryKey(id);
		
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		if(contentCatMapper.selectByExample(example).size()==0) {//查找父节点为parentId的节点个数
			// 查找父节点
			TbContentCategory category = contentCatMapper.selectByPrimaryKey(parentId);
			category.setIsParent(false);
			contentCatMapper.updateByPrimaryKey(category);
		}
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult updateContentCat(long id, String name) {
		TbContentCategory category = contentCatMapper.selectByPrimaryKey(id);
		category.setName(name);
		category.setUpdated(new Date());
		contentCatMapper.updateByPrimaryKey(category);
		return TaotaoItemResult.ok();
	}

}
