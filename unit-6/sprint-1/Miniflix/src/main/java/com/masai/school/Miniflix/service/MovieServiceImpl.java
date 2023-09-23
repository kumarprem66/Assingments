package com.masai.school.Miniflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.school.Miniflix.entity.Movie;
import com.masai.school.Miniflix.repository.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDAO movieDao;
	
	@Override
	public List<Movie> addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieDao.add(movie);
	}

	@Override
	public List<Movie> removeById(int id) {
		// TODO Auto-generated method stub
		return movieDao.delete(id);
	}

	@Override
	public Movie getMovieById(int id) {
		// TODO Auto-generated method stub
		return movieDao.findById(id);
	}

	@Override
	public List<Movie> updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieDao.delete(movie.getId());
		movieDao.add(movie);
		return movieDao.findAll();
	}

}
