package com.prem.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prem.springproject.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	
}
