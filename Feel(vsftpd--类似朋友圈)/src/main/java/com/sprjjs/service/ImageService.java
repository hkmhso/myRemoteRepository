package com.sprjjs.service;


import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sprjjs.pojo.Image;

public interface ImageService {
	//�ļ��ϴ���ͼƬ������vsftpd
	Map<String,Object> upload(MultipartFile ImgFile) throws Exception;
}
