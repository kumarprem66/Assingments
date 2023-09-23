package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Order;
import com.example.demo.exception.OrderException;

public interface OrderService {

	

	Order saveOrder(Order order);
	Order getOrderById(Integer id) throws OrderException;
	List<Order> getAllOrder(int customerId) throws OrderException;
	Order deleteOrderById(Integer roll) throws OrderException;
	
	
}
