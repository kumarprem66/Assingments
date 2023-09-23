package com.masaischool.swiggy3.repository;

import com.masaischool.swiggy3.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
