package com.frame.controller;

import com.frame.entity.Movie;
import com.frame.entity.Test;
import com.frame.service.MovieInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.service.DemoService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

	@Resource
	private DemoService demoService;

	@Resource
	private MovieInfoService movieInfoService;

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("执行hello控制器方法");
		// 调用业务层执行查询操作
		//List<Test> res = demoService.test();
		//System.out.println(res);
		List<Movie> movies = new ArrayList<Movie>();
		Movie m = new Movie();
		m.setId(1);
		movies.add(m);
		Movie m1 = new Movie();
		m1.setId(2);
		movies.add(m1);
		List<Movie> ms = movieInfoService.getMovieByMovieId2(movies);
		for(int i=0;i<ms.size();i++){
			System.out.println(ms.get(i));
		}
		return "hello";
	}
}