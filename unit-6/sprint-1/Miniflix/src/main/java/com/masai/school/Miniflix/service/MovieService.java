package com.masai.school.Miniflix.service;

import java.util.List;

import com.masai.school.Miniflix.entity.Movie;

public interface MovieService {

	List<Movie> addMovie(Movie movie);
	List<Movie> removeById(int id);
	Movie getMovieById(int id);
	List<Movie> updateMovie(Movie movie);
}
