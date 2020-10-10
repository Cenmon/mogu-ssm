package com.mogu.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogu.manager.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public EUDataGridResult getContentList(Long categoryId,int page, int rows) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		PageHelper.startPage(page, rows);
		List<TbContent> list = contentMapper.selectByExample(example);
		
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public TaotaoItemResult insertContent(TbContent content) {
		content.setUpdated(new Date());
		content.setCreated(new Date());
		
		contentMapper.insert(content);
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult deleteContent(long id) {
		contentMapper.deleteByPrimaryKey(id);
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult editContent(TbContent content) {
		contentMapper.updateByPrimaryKeySelective(content);
		return TaotaoItemResult.ok();
	}
}
