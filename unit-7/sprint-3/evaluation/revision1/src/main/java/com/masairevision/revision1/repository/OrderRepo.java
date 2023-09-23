package com.masairevision.revision1.repository;

import com.masairevision.revision1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
