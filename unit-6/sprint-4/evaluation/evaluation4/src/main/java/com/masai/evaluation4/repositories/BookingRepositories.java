package com.masai.evaluation4.repositories;

import com.masai.evaluation4.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepositories extends JpaRepository<Booking,Integer> {
}
