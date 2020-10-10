package com.mogu.sso.testUpdate;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.mapper.TbAdminMapper;
import com.taotao.pojo.TbAdmin;
import com.taotao.pojo.TbAdminExample;
import com.taotao.pojo.TbAdminExample.Criteria;

public class testUpdate {
	
	@Autowired
	private TbAdminMapper adminMapper;
	 
	@Test
	public void UpdateTest() {
		TbAdmin admin = new TbAdmin();
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo("陈莫");
		adminMapper.updateByExampleSelective(null, example);
	}
}
