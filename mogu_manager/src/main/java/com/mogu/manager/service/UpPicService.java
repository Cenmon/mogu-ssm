package com.mogu.manager.service;

import org.springframework.web.multipart.MultipartFile;

import taotao_common.PicResult;

public interface UpPicService {
	public PicResult uploadPicture(MultipartFile uploadFile);
}
