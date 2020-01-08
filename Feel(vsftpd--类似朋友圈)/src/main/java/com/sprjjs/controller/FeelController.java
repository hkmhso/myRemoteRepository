package com.sprjjs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprjjs.pojo.Feel;
import com.sprjjs.service.impl.FeelServiceImpl;

@Controller
public class FeelController {
	@Autowired
	private FeelServiceImpl feelServiceImpl;
	/**
	 * @RequestParam(value="img")表示：当请求参数中有多个同名的参数时的获取方法
	 * @param feel
	 * @param imgs
	 * @return
	 */
	//发表
	@RequestMapping("publish")
	public String publish(Feel feel,@RequestParam(value="img")List<String> imgs){
		int index = feelServiceImpl.insFeel(feel, imgs);
		if(index>0){
			return "success";
		}
		return "fail";
	}

}
