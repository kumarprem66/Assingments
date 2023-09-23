package com.prem.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prem.springproject.entities.User;

public interface UserRepo  extends JpaRepository<User, Integer> , PagingAndSortingRepository<User, Integer>{

}
