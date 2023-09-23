package com.masairevision.revision1.repository;

import com.masairevision.revision1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  CustomerRepo extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByEmail(String email);

}
