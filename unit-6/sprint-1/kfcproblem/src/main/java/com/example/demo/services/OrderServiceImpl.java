package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.exception.OrderException;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		Order savedorder = orderRepository.save(order);
		
		return savedorder;
	}

	@Override
	public Order getOrderById(Integer id) throws OrderException {
		// TODO Auto-generated method stub
		Optional<Order> opt = orderRepository.findById(id);
//		if(opt.isPresent()) {
//			Order existingOrder = opt.get();
//			return existingOrder;
//		}else {
//			throw new OrderException("order does not exist with this id "+id);
//			
//		}
		
//		shortcut
		return opt.orElseThrow(() -> new OrderException("order does not exist with this id "+id));
		
	}

	@Override
	public List<Order> getAllOrder(int customerId) throws OrderException {
		// TODO Auto-generated method stub
		List<Order> orders = orderRepository.findAll();
		List<Order> customerorders = new ArrayList<>();
		for(Order order : orders) {
			if(order.getId()==customerId) {
				customerorders.add(order);
			}
		}
		if(customerorders.isEmpty()) {
			throw new OrderException("No ordes found");
		}else {
			return customerorders;
		}
	}
		

	@Override
	public Order deleteOrderById(Integer id) throws OrderException {
	
		Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new OrderException("order does not exist with this id"+id));
		orderRepository.delete(existingOrder);
		return existingOrder;
		
		
	}

}
