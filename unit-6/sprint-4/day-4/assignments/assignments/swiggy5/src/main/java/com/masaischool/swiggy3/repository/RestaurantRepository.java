package com.masaischool.swiggy3.repository;

import com.masaischool.swiggy3.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {



    Optional<Restaurant> findByName(String name);

}
