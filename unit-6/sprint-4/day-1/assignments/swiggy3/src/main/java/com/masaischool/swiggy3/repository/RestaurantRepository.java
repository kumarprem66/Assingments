package com.masaischool.swiggy3.repository;

import com.masaischool.swiggy3.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
