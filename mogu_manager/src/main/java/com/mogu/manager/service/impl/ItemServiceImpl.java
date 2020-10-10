package com.mogu.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogu.manager.service.ItemService;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;
import taotao_utils.IDUtils;


@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	
	// 新增商品时，用于添加商品描述信息
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	//用于添加商品规格参数信息
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		//根据主键查询
//		TbItem item = itemMapper.selectByPrimaryKey(itemId);

		//根据查询条件查询
		TbItemExample example = new TbItemExample();
		//添加查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	// 商品列表查询
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页插件处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoItemResult AddItem(TbItem item,TbItemDesc itemDesc,String itemParam) throws Exception {
		// 生成商品id
		Long itemId = IDUtils.genItemId();

		// 补全商品pojo
		item.setId(itemId);
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());	
		itemMapper.insert(item);	
		
		if(AddItemDesc(itemId, itemDesc).getStatus() != 200) {
			throw new Exception();
		}
		
		if(AddItemParam(itemId, itemParam).getStatus() != 200) {
			throw new Exception();
		}
		
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult AddItemDesc(long itemId, TbItemDesc itemDesc) {
		// 补全商品描述pojo
		itemDesc.setItemId(itemId);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		
		itemDescMapper.insert(itemDesc);
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult AddItemParam(long itemId, String itemParam) {
		// 新建商品参数pojo类
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		// 插入商品参数
		itemParamItemMapper.insert(itemParamItem);
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult DeleteItem(long[] ids) {
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		for (long id : ids) {
			criteria.andIdEqualTo(id);
			itemMapper.deleteByExample(example);
		}
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult InstockItem(long[] ids) {
		for (long id : ids) {
			itemMapper.updateStatusById((long)2,id);
		}
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult ReshelfItem(long[] ids) {
		for (long id : ids) {
			itemMapper.updateStatusById((long)1,id);
		}
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult UpdateItem(TbItem item) {
		itemMapper.updateByExample(item, null);
		return TaotaoItemResult.ok();
	}
}
