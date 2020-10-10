package com.mogu.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogu.manager.service.ItemDescService;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemDescExample;
import com.taotao.pojo.TbItemDescExample.Criteria;

@Service
public class ItemDescServiceImpl implements ItemDescService {

	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Override
	public TbItemDesc getItemDescById(long id) {
		TbItemDescExample example = new TbItemDescExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(id);
		List<TbItemDesc> list = itemDescMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
