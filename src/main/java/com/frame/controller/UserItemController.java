package com.frame.controller;

import com.frame.entity.MovieInfo;
import com.frame.recommender.UserItem;
import com.frame.service.MovieInfoService;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserItemController {
    @Resource
    private MovieInfoService movieInfoService;

    @RequestMapping("/item")
    public String hello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行item控制器方法");
        //接收用户id
        long userID = Long.parseLong(request.getParameter("userID"));
        //接收size
        int size = Integer.parseInt(request.getParameter("size"));
        //接收推荐类型参数
        //String recommendType = request.getParameter("recommendType");

        System.out.println(userID+" "+size);
        //用户的所有电影
        List<MovieInfo> movieInfos = movieInfoService.getMovieInfoById(userID);
        for(int i=0;i<movieInfos.size();i++){
            System.out.println(movieInfos.get(i));
        }

        //推荐电影的List
        List<RecommendedItem> recommendation = null;

        UserItem userItem = new UserItem();
        //拿到推荐的电影
        System.out.println("推荐中。。。。。");
        recommendation = userItem.userBasedRecommender(userID,size);
        System.out.println("推荐结果为:"+recommendation);
        System.out.println("推荐结束。。。。");

        //拿到推荐的电影的详细信息
        List<MovieInfo> recommendMovieInfo = movieInfoService.getMovieByMovieId(recommendation);
        System.out.println("拿到的电影详细信息为："+recommendMovieInfo);

        //页面跳转
        request.setAttribute("ownMovieInfo", movieInfos);
        request.setAttribute("recommendMovieInfo", recommendMovieInfo);
        //request.getRequestDispatcher("recommendResult.jsp").forward(request, response);
        return "recommendResult";
    }
}
