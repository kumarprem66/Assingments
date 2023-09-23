package com.masai.school.Miniflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.masai.school.Miniflix.entity.Series;
import com.masai.school.Miniflix.service.SeriesService;

@Controller
public class SeriesController {

	  @Autowired
	    private SeriesService seriesService;

	    public List<Series> addSeries(Series series) {
	        return seriesService.addSeries(series);
	    }

	    public List<Series> removeSeries(int id) {
	        return seriesService.removeSeries(id);
	    }

	    public Series getMovieById(int id) {
	        return seriesService.getSeriesById(id);
	    }

	    public List<Series> updateSeries(Series Series) {
	        return seriesService.updateSeries(Series);
	    }
	
}
