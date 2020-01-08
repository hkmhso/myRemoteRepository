package com.sprjjs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprjjs.mapper.FeelMapper;
import com.sprjjs.mapper.ImageMapper;
import com.sprjjs.pojo.Feel;
import com.sprjjs.pojo.Image;
import com.sprjjs.service.FeelService;
import com.sprjjs.utils.IDUtils;

@Service
public class FeelServiceImpl implements FeelService{
	@Autowired
	private FeelMapper feelMapper;
	@Autowired
	private ImageMapper imageMapper;
	//����
	@Override
	public int insFeel(Feel feel,List<String> imgs){
		// TODO Auto-generated method stub
		//��ȡ������ɵ�id
		long id = IDUtils.genItemId();
		feel.setId(id);
		int index = feelMapper.insertSelective(feel);
		if(index>0){
			//�˴�������һ���������Ի��漰������ع���������Ӷ���֤���ݵ�������
			for(String img:imgs){
				Image image=new Image();
				image.setFid(id);
				image.setPath(img);
				index+= imageMapper.insertSelective(image);
			}
			if(index==imgs.size()+1){
				return 1;
			}
		}
		return 0;
	}
	

}
