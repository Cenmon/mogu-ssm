package com.mogu.manager.service;



import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;

public interface UserService {
	EUDataGridResult getUserList(Integer page,Integer rows);
	
	TaotaoItemResult deleteUsers(long[] ids);
}
