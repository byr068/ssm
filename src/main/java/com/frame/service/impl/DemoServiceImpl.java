package com.frame.service.impl;

import com.frame.entity.Test;
import com.frame.mapper.DemoMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.service.DemoService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

	//@Autowired
	//private SqlSessionTemplate sqlSessionTemplate;

	@Resource
	private DemoMapper demoMapper;

	// mybatis sql模板的命名空间
	//private static final String NAMESPACE = "com.frame.mapper.DemoMapper";

//	@Override
//	public void test() {
//		System.out.println("返回查询结果集 -> " + sqlSessionTemplate.selectList(NAMESPACE + ".getTest")); // 查询结果集
//	}

	public List<Test> test(){
		return demoMapper.getAll();
	}
}