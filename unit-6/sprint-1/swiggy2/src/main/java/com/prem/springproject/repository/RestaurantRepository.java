package com.prem.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prem.springproject.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	
}
