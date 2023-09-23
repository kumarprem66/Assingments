package com.prem.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prem.springproject.entities.Playlist;

public interface PlaylistRepo  extends JpaRepository<Playlist, Integer> , PagingAndSortingRepository<Playlist, Integer>{

	
}
