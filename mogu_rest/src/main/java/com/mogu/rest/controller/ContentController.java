package com.mogu.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.rest.service.ContentService;
import com.taotao.pojo.TbContent;

@Controller
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/list/{cid}")
	@ResponseBody
	public List<TbContent> getContentByCid(@PathVariable long cid){
		return contentService.getContentByCid(cid);
	}
}
