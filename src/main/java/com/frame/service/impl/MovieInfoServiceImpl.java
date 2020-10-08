package com.frame.service.impl;

import com.frame.entity.Movie;
import com.frame.entity.MovieInfo;
import com.frame.mapper.MovieInfoMapper;
import com.frame.service.MovieInfoService;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Resource
    private MovieInfoMapper movieInfoMapper;

    public List<MovieInfo> getMovieInfoById(long id){

        return movieInfoMapper.getMovieInfoById(id);
    }

    public List<MovieInfo> getMovieByMovieId(List<RecommendedItem> recommendedItems) {
        List<Movie> movies = new ArrayList<Movie>();
        System.out.println("进去赋值。。。");
        for(int i=0;i<recommendedItems.size();i++){
            Movie m = new Movie();
            m.setId(recommendedItems.get(i).getItemID());
            movies.add(m);
        }
        List<Movie> movie = movieInfoMapper.getMovieByMovieId(movies);
        System.out.println("走到这了吗。。。");
        for(int i=0;i<movie.size();i++){
            System.out.println("查询电影为："+movie.get(i));
        }

        List<MovieInfo> movieInfos = new ArrayList<MovieInfo>();
        for(int i=0;i<movie.size();i++){
            MovieInfo movieInfo = new MovieInfo();
            movieInfo.setName(movie.get(i).getName());
            movieInfo.setPublishedYear(movie.get(i).getYear());
            movieInfo.setType(movie.get(i).getType());
            movieInfo.setPreference(recommendedItems.get(i).getValue());
            movieInfos.add(movieInfo);
        }
        System.out.println("要返回的电影信息为："+movieInfos);

        return movieInfos;
    }

    public List<Movie> getMovieByMovieId2(List<Movie> movies) {
        System.out.println("走到了");
        List<Movie> movie = movieInfoMapper.getMovieByMovieId(movies);
        System.out.println("没问题");
        return movie;
    }
}
