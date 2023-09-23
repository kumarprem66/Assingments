package com.masai.school.Miniflix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.school.Miniflix.config.AppConfig;
import com.masai.school.Miniflix.controller.MovieController;
import com.masai.school.Miniflix.controller.SeriesController;
import com.masai.school.Miniflix.entity.Movie;
import com.masai.school.Miniflix.entity.Series;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
    	
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	MovieController mc = ctx.getBean(MovieController.class);
    	SeriesController sc = ctx.getBean(SeriesController.class);
    	System.out.println(mc.getMovieById(4));
    	
    	System.out.println(mc.addMovie(new Movie(5,"sjfhshf","ere",120,9.3)));
    	System.out.println(sc.addSeries(new Series(8,"fgdsgg",20,"shfks")));
    	
    }
}
