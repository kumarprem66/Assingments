package com.masai.school.Miniflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.masai.school.Miniflix.entity.Movie;
import com.masai.school.Miniflix.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movie;
	
	public List<Movie> addMovie(Movie mov){
		return movie.addMovie(mov);
	}
	
	public List<Movie> removeMovie(int id){
		return movie.removeById(id);
	}
	
	public Movie getMovieById(int id){
		return movie.getMovieById(id);
	}
	
	public List<Movie> updateMovie(Movie mov){
		return movie.updateMovie(mov);
	}
	
	
}
