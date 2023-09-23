package com.masai.school.Miniflix.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.masai.school.Miniflix.entity.Series;

@Repository
public class SeriesDAO {

	
	@Autowired
	private List<Series> listSeries;
	
	
	public List<Series> findAll(){
		return listSeries;
	}
	
	
	public Series findById(int id) {
		for(int i=0;i<listSeries.size();i++) {
			if(listSeries.get(i).getId()==id) {
				return listSeries.get(i);
			}
		}
		return null;
	}
	
	 public List<Series> delete(int id) {
			for(int i=0;i<listSeries.size();i++) {
				if(listSeries.get(i).getId()==id) {
					listSeries.remove(i);
				}
			}
	        return listSeries;
	   }

	    public List<Series> add(Series series) {
	    	listSeries.add(series);
	        return listSeries;
	    }
}
