package com.masai.school.Miniflix.service;

import java.util.List;

import com.masai.school.Miniflix.entity.Series;

public interface SeriesService {

	
	List<Series> addSeries(Series series);
	
	List<Series> removeSeries(int id);
	
	Series getSeriesById(int id);
	
	List<Series> updateSeries(Series series);
}
