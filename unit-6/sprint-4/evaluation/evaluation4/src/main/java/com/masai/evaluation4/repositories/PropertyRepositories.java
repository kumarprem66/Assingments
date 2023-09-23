package com.masai.evaluation4.repositories;

import com.masai.evaluation4.entities.Booking;
import com.masai.evaluation4.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepositories extends JpaRepository<Property,Integer> {
}
