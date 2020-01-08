package com.sprjjs.service;


import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sprjjs.pojo.Image;

public interface ImageService {
	//文件上传到图片服务器vsftpd
	Map<String,Object> upload(MultipartFile ImgFile) throws Exception;
}
