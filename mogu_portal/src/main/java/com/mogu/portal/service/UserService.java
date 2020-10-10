package com.mogu.portal.service;

import com.taotao.pojo.TbUser;

public interface UserService {
	TbUser getUserByToken(String token);
}
