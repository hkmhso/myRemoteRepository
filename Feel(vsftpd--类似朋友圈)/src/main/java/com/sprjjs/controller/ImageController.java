package com.sprjjs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sprjjs.service.impl.ImageServiceImpl;
@Controller
public class ImageController {
	@Autowired
	private ImageServiceImpl imageServiceImpl;
	//图片上传到图片服务器
	@RequestMapping("js/kindeditor/php/upload_json.php")
	@ResponseBody
	public Map<String,Object> upload(MultipartFile imgFile){
		System.out.println("控制器");
		try {
			return imageServiceImpl.upload(imgFile);
	    }catch(Exception e){
	    	e.getMessage();
	    }
		return null;
    }
}
