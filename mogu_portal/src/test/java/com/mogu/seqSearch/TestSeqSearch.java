package com.mogu.seqSearch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.taotao.pojo.TbUser;

import taotao_utils.HttpClientUtil;

public class TestSeqSearch {
	@Test
	public void TestArrayList() {
		// ArrayList为数组列表，存储的是列表元素指针，获取元素指针后修改元素，也将作用于列表，即等价于列表操作
		TbUser user = new TbUser();
		user.setUsername("Cenmo");
		user.setPassword("123456");
		List<TbUser> list = new ArrayList<>();
		list.add(user);
		System.out.println(list.get(0).getUsername());
		user.setUsername("陈莫");
		System.out.println(list.get(0).getUsername());
		System.out.println(list.get(0));
		System.out.println(user);
		System.out.println(list.get(0) == user);
	}
	
	@Test
	public void TestSeqSearch() {
		List<TbUser> list = new ArrayList<>();
		for(long i=1;i<=10;i++) {
			TbUser user = new TbUser();
			user.setId(i);
			list.add(user);
		}
		
		//添加哨兵：放到末尾
		TbUser user = new TbUser();
		user.setId((long)4);
		list.add(user);
		
		//哨兵查找
		int index=0;
		for(;list.get(index).getId() != 4;index++);
		System.out.println(index);
		//删除最后一个
		list.remove(list.size()-1);
		System.out.println(list.get(list.size()-1).getId());
	}
	
	@Test
	public void TestRest() {
		String string = HttpClientUtil.doGet("http://localhost:8081/rest/item/info/159109992187338");
		System.out.println(string);
	}
}
