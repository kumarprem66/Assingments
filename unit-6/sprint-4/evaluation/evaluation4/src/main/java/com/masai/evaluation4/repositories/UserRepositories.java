package com.masai.evaluation4.repositories;

import com.masai.evaluation4.entities.Booking;
import com.masai.evaluation4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositories extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
