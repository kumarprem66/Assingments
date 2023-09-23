package com.masaischool.swiggy3.repository;

import com.masaischool.swiggy3.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {



    Optional<Customer> findByEmail(String email);
}
