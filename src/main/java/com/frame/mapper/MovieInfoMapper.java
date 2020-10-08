package com.frame.mapper;

import com.frame.entity.Movie;
import com.frame.entity.MovieInfo;

import java.util.List;

public interface MovieInfoMapper {

    List<MovieInfo> getMovieInfoById(long id);

    List<Movie> getMovieByMovieId(List<Movie> m);
}
