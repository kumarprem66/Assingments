package com.masaischool.round6.repository;

import com.masaischool.round6.entity.Blog;
import com.masaischool.round6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepos extends JpaRepository<User,Integer> {


    Optional<User> findByEmail(String email);
}
