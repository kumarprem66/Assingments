package com.masai.evaluation4.repositories;

import com.masai.evaluation4.entities.Booking;
import com.masai.evaluation4.entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host,Integer> {
}
