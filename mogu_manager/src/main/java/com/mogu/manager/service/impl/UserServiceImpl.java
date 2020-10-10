package com.mogu.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogu.manager.service.UserService;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	
	/**
	 * 获取用户列表
	 */
	@Override
	public EUDataGridResult getUserList(Integer page, Integer rows) {
		//通过分页插件获取分页信息
		TbUserExample example = new TbUserExample();
		PageHelper.startPage(page, rows);
		
		List<TbUser> list = userMapper.selectByExample(example);
		
		//转化为DataGrid所需结构
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 删除多个id用户
	 */
	@Override
	public TaotaoItemResult deleteUsers(long[] ids) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		//遍历ids，依次删除每一个id用户
		for (long id : ids) {
			criteria.andIdEqualTo(id);
			userMapper.deleteByExample(example);			
		}
		return TaotaoItemResult.ok();
	}

}
