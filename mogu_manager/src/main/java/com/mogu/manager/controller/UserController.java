package com.mogu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.UserService;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/list")
	@ResponseBody
	public EUDataGridResult getUserList(long page,long rows) {
		return userService.getUserList((int)page,(int)rows);
	}
	
	/**
	 * 通过多个id删除多个用户
	 * @param ids
	 * @return
	 */
	@RequestMapping("/user/delete")
	@ResponseBody
	public TaotaoItemResult deleteUserByIds(long[] ids) {
		if(userService.deleteUsers(ids).getStatus()!=200) {
			return TaotaoItemResult.error();
		}
		return TaotaoItemResult.ok();
	}
}
