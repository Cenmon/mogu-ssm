package com.mogu.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mogu.manager.service.UpPicService;

import taotao_common.PicResult;

@Controller
public class UpPicController {
	@Autowired
	private UpPicService upPicService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicResult upload(MultipartFile uploadFile) {
		PicResult result = upPicService.uploadPicture(uploadFile);
		return result;
	}
}
