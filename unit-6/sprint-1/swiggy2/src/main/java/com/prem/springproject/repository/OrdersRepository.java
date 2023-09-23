package com.prem.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prem.springproject.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
