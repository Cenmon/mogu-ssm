package com.mogu.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogu.manager.service.ItemParamService;
import com.taotao.mapper.TbItemParamCatMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamCat;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Autowired
	private TbItemParamCatMapper itemParamCatMapper;
	
	@Override
	public TaotaoItemResult getItemParamByCid(long cid) {
		// 通过商品类别cid查找数据库是否有参数模板
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		if(list!=null && list.size()>0) {
			return TaotaoItemResult.ok(list.get(0));
		}
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult insertItemParam(TbItemParam itemParam) {
		// 补全itemparam类
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		
		itemParamMapper.insert(itemParam);
		return TaotaoItemResult.ok();
	}

	@Override
	public EUDataGridResult getItemParamList(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TbItemParamCat> list = itemParamCatMapper.selectByItemParamId();
		
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		PageInfo<TbItemParamCat> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public TaotaoItemResult deleteItemParam(long ids) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(ids);
		itemParamMapper.deleteByExample(example);
		return TaotaoItemResult.ok();
	}

}
