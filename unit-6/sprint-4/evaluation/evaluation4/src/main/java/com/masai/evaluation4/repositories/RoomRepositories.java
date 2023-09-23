package com.masai.evaluation4.repositories;

import com.masai.evaluation4.entities.Booking;
import com.masai.evaluation4.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepositories extends JpaRepository<Room,Integer> {
}
