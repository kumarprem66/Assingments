package com.prem.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prem.springproject.entities.Album;

public interface AlbumRepo extends JpaRepository<Album, Integer> , PagingAndSortingRepository<Album, Integer>{
	
	

}
