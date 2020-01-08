package com.sprjjs.service.impl;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sprjjs.mapper.ImageMapper;
import com.sprjjs.pojo.Image;
import com.sprjjs.service.ImageService;
import com.sprjjs.utils.FtpUtil;
@Service
public class ImageServiceImpl implements ImageService{
	//采用软编码将图片服务器相关的信息获取到
	@Value("${ftpclient.host}")
	//ip地址
	private String host;
	@Value("${ftpclient.port}")
	//端口
	private int port;
	@Value("${ftpclient.username}")
	//用户名
	private String username;
	@Value("${ftpclient.password}")
	//用户密码
	private String password;
	@Value("${ftpclient.basePath}")
	//图片服务器的根目录
	private String basePath;
	@Value("${ftpclient.filePath}")
	//图片存储的目录
	private String filePath;
	private ImageMapper imageMapper;
	//文件上传到图片服务器vsftpd
	@Override
	public Map<String,Object> upload(MultipartFile imgFile) throws Exception{
		System.out.println("业务层");
		//文件名
		String filename=UUID.randomUUID()+imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
		boolean uploadFile = FtpUtil.uploadFile(host, port, username, password, basePath,filePath, filename, imgFile.getInputStream());
		Map<String,Object> map=new HashMap<>();
		if(uploadFile){
			//上传成功
			map.put("error",0);
			map.put("url", "http://192.168.253.132"+filePath+filename);
			return map;
		}
		//上传失败
		map.put("error", 1);
		map.put("message", "图片上传失败");
		return map;
	}

}
