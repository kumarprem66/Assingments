package com.masairevision.revision1.repository;

import com.masairevision.revision1.entity.Customer;
import com.masairevision.revision1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  ProductRepo extends JpaRepository<Product,Integer> {


    Optional<Product> findByName(String email);
}
