package com.masai.school.Miniflix.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.masai.school.Miniflix.entity.Movie;
import com.masai.school.Miniflix.entity.Series;

@Configuration
@ComponentScan("com.masai")
public class AppConfig {

	
	@Bean
	public List<Movie> movieList(){
		
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1,"KGF","SJFHSKAF",2,9));
		movies.add(new Movie(2,"ABC","SJFHSKAF",2,9));
		movies.add(new Movie(3,"XYZ","skafasflafa",2,7.8));
		movies.add(new Movie(4,"IGF","sfnskfnkasnfk",2,4.5));
		
		return movies;
	}
	
	
	
	@Bean
	public List<Series> sereisList(){
		
		List<Series> series = new ArrayList<>();
		series.add(new Series(1,"sfsaf",10,"sfasfsf"));
		series.add(new Series(2,"sfsf",13,"sfhakf"));
		series.add(new Series(3,"gjksgj",30,"sfasfsf"));
		series.add(new Series(4,"ererer",10,"sfasfsf"));
		
		return series;
	}
	
	
}
