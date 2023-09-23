package com.masai.school.Miniflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.school.Miniflix.entity.Series;
import com.masai.school.Miniflix.repository.SeriesDAO;


@Service
public class SeriesServiceImpl implements SeriesService{

	@Autowired
	private SeriesDAO seriesdao;
	
	
	@Override
	public List<Series> addSeries(Series series) {
		
		return seriesdao.add(series);
	}

	@Override
	public List<Series> removeSeries(int id) {
		// TODO Auto-generated method stub
		return seriesdao.delete(id);
	}

	@Override
	public Series getSeriesById(int id) {
		// TODO Auto-generated method stub
		return seriesdao.findById(id);
	}

	@Override
	public List<Series> updateSeries(Series series) {
		// TODO Auto-generated method stub
		seriesdao.delete(series.getId());
		seriesdao.add(series);
		return seriesdao.findAll();
	}

	
	
}
