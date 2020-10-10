package com.mogu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.rest.service.RedisService;

import taotao_common.TaotaoItemResult;

@Controller
@RequestMapping("/cache/sync")
public class RedisController {
	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{cid}")
	@ResponseBody
	public TaotaoItemResult syncContent(@PathVariable long cid) {
		return redisService.syncContent(cid);
	}
	
	@RequestMapping("/itemCat")
	@ResponseBody
	public TaotaoItemResult syncItemCat() {
		return redisService.syncItemCat();
	}
}
