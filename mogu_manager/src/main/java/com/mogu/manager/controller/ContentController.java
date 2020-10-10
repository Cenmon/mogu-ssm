package com.mogu.manager.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogu.manager.service.ContentService;
import com.taotao.pojo.TbContent;

import taotao_common.EUDataGridResult;
import taotao_common.TaotaoItemResult;
import taotao_utils.HttpClientUtil;

@Controller
//@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@Value("${rest.baseUrl}")
	private String REST_BASEURL;
	
	@Value("${rest.content.sync.url}")
	private String REST_CONTENT_SYNC_URL;
	
	@RequestMapping("/content/list")
	@ResponseBody
	public EUDataGridResult getContentList(Long categoryId,Integer page,Integer rows) {
		return contentService.getContentList(categoryId,page, rows);
	}
	
	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoItemResult insertContent(TbContent content) {
		TaotaoItemResult result = contentService.insertContent(content);
		HttpClientUtil.doGet(REST_BASEURL+REST_CONTENT_SYNC_URL);
		return result;
	}
	
	@RequestMapping("/content/delete")
	@ResponseBody
	public TaotaoItemResult deleteContent(long[] ids) {
		try {
			for(long id:ids) {
				contentService.deleteContent(id);
			}
			HttpClientUtil.doGet(REST_BASEURL+REST_CONTENT_SYNC_URL);
			return TaotaoItemResult.ok();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return TaotaoItemResult.error();
		}
	}
	
	@RequestMapping("/rest/content/edit")
	@ResponseBody
	public TaotaoItemResult editContent(TbContent content) {
		content.setUpdated(new Date());
		TaotaoItemResult result = contentService.editContent(content);
		HttpClientUtil.doGet(REST_BASEURL+REST_CONTENT_SYNC_URL);
		return result;
	}
}
