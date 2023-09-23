package com.prem.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prem.springproject.entities.Song;

public interface SongRepo  extends JpaRepository<Song, Integer> , PagingAndSortingRepository<Song, Integer>{

}
