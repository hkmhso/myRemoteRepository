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
	//��������뽫ͼƬ��������ص���Ϣ��ȡ��
	@Value("${ftpclient.host}")
	//ip��ַ
	private String host;
	@Value("${ftpclient.port}")
	//�˿�
	private int port;
	@Value("${ftpclient.username}")
	//�û���
	private String username;
	@Value("${ftpclient.password}")
	//�û�����
	private String password;
	@Value("${ftpclient.basePath}")
	//ͼƬ�������ĸ�Ŀ¼
	private String basePath;
	@Value("${ftpclient.filePath}")
	//ͼƬ�洢��Ŀ¼
	private String filePath;
	private ImageMapper imageMapper;
	//�ļ��ϴ���ͼƬ������vsftpd
	@Override
	public Map<String,Object> upload(MultipartFile imgFile) throws Exception{
		System.out.println("ҵ���");
		//�ļ���
		String filename=UUID.randomUUID()+imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
		boolean uploadFile = FtpUtil.uploadFile(host, port, username, password, basePath,filePath, filename, imgFile.getInputStream());
		Map<String,Object> map=new HashMap<>();
		if(uploadFile){
			//�ϴ��ɹ�
			map.put("error",0);
			map.put("url", "http://192.168.253.132"+filePath+filename);
			return map;
		}
		//�ϴ�ʧ��
		map.put("error", 1);
		map.put("message", "ͼƬ�ϴ�ʧ��");
		return map;
	}

}
