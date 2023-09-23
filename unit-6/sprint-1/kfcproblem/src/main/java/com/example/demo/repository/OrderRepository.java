package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query("Select o from orders where o.customerPhone = :ph")
	public List<Order> getOrderBYCustomerPhone(@Param("ph") String phone);
	
	
	public List<String> getTopThreeCustomer();
	
	public String getDayNameHasMaximumOrder();
}
