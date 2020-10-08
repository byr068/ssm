package com.frame.service;


import com.frame.entity.Movie;
import com.frame.entity.MovieInfo;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.List;

public interface MovieInfoService {
    List<MovieInfo> getMovieInfoById(long id);

    List<MovieInfo> getMovieByMovieId( List<RecommendedItem> recommendedItems);

    List<Movie> getMovieByMovieId2(List<Movie> movies);
}
