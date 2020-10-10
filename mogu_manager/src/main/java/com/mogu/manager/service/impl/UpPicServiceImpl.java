package com.mogu.manager.service.impl;

import java.io.IOException;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mogu.manager.service.UpPicService;

import taotao_common.PicResult;
import taotao_utils.FtpUtil;

@Service
public class UpPicServiceImpl implements UpPicService {
	@Value("${FTP.address}")
	private String FTP_ADDRESS;
	@Value("${FTP.port}")
	private Integer FTP_PORT;
	@Value("${FTP.userName}")
	private String FTP_USER_NAME;
	@Value("${FTP.password}")
	private String FTP_PASSWORD;
	@Value("${FTP.basePath}")
	private String FTP_BASE_PATH;
	@Value("${HTTP.baseUrl}")
	private String HTTP_BASE_URL;
	
	@Override
	public PicResult uploadPicture(MultipartFile uploadFile) {
		if(uploadFile == null || uploadFile.isEmpty()) {
			return PicResult.error("上传图片为空");
		}
		//获取后缀名
		String originalFileName = uploadFile.getOriginalFilename();
		String postfix = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		//生成图片名称
		String imageName = UUID.randomUUID().toString() + postfix;
		
		//文件路径名称
		//joda-time的jar包中的方法，用于对时间的操作
		String filePath = new DateTime().toString("/yyyyMMdd");
		
		try {
			FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, FTP_BASE_PATH, 
										filePath, imageName, uploadFile.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return PicResult.error("图片上传异常");
		}
		//返回图片路径
		return PicResult.ok(HTTP_BASE_URL+filePath+"/"+imageName);
	}
}
