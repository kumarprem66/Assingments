package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Customer;
import com.example.demo.entity.DeliveryPartner;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderStatus;
import com.example.demo.entity.Restaurant;
import com.example.demo.exception.InvalidEmailException;
import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.InvalidStateException;
import com.example.demo.exception.NotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class DeliveryService {

	
	private final Map<String,Customer> customers = new HashMap<>();
	private final Map<String,Restaurant> restaurants = new HashMap<>();
	private final Map<String,DeliveryPartner> deliveryPartners = new HashMap<>();
	private final Map<String,Order> orders = new HashMap<>();
	private  List<String> validStatus;
	
	
	@PostConstruct
	public void init() {
		  Customer customer1 = new Customer("c1", "John Doe", "john.doe@example.com", "123 Street");
	        customers.put(customer1.getCustomerId(), customer1);
	        
	        Restaurant restaurant1 = new Restaurant("r1", "Pizza Hut", "456 Street");
	        restaurants.put(restaurant1.getRestaurantId(), restaurant1);

	        DeliveryPartner deliveryPartner1 = new DeliveryPartner("d1", "Paul", "5555555555");
	        deliveryPartners.put(deliveryPartner1.getDeliveryPartnerId(), deliveryPartner1);
	        
	        validStatus = Arrays.asList("cooking", "on the way", "delivered");
	}
	
	public void addCustomer(Customer customer) {
		validateCustomer(customer);
		customers.put(customer.getCustomerId(), customer);
		
	}

	public void addRestaurant(Restaurant restaurant) {
		validateRestaurant(restaurant);
		restaurants.put(restaurant.getRestaurantId(), restaurant);
		
	}
	
	public void addDeliverPartner(DeliveryPartner deliveryPartner) {
		validateDeliveryPartner(deliveryPartner);
		deliveryPartners.put(deliveryPartner.getDeliveryPartnerId(), deliveryPartner);
		
	}
	public void placeOrder(Order order) {
		validateOrder(order);
		orders.put(order.getOrderId(), order);
		
	}
	
	
	public void assignDeliveryPartner(String orderId,String deliveryPartnerId) {
		 Order order = orders.get(orderId);
	        if (order == null) {
	            throw new NotFoundException("Order not found");
	        }

	        DeliveryPartner deliveryPartner = deliveryPartners.get(deliveryPartnerId);
	        if (deliveryPartner == null) {
	            throw new NotFoundException("Delivery partner not found");
	        }

	        if (order.getDeliveryPartnerId() != null) {
	            throw new InvalidStateException("Order already has a delivery partner");
	        }

	        order.setDeliveryPartnerId(deliveryPartnerId);
	}
	
	
	public void updateOrderStatus(String id, OrderStatus orderstatus) {
		Order order = orders.get(id);
		
        if (order == null) {
            throw new NotFoundException("Order not found");
        }

        if (order.getOrderStatus() == OrderStatus.DELIVERED) {
            throw new InvalidInputException("Cannot change the status of a delivered order");
        }

        order.setOrderStatus(orderstatus);
	}
	
	public  List<Order> fetchCustomerOrderHistory(String cusid){
		
		Customer customer = customers.get(cusid);
		if(customer == null) {
			throw new NotFoundException("Custmer is not found");
			
		}
		
		List<Order> customersOrders = new ArrayList<>();
		for(Order order : orders.values()) {
			if(order.getCustomerId().equals(cusid)) {
				customersOrders.add(order);
			}
		}
		return customersOrders;
		
	}
	
	private void validateCustomer(Customer customer) {
	
		if(!StringUtils.hasText(customer.getName()) || !StringUtils.hasText(customer.getAddress()) 
				|| !StringUtils.hasText(customer.getEmail())) {
			throw new InvalidInputException("Customer details are incomplete");
		}
		
		if (!Pattern.matches("^[\\w-.]+@([\\w-]+.)+[\\w-]{2,4}$", customer.getEmail())) {
            throw new InvalidEmailException("Email is not valid");
        }
	}
	
	
	
	   private void validateRestaurant(Restaurant restaurant) {
	        if (!StringUtils.hasText(restaurant.getName())) {
	            throw new InvalidInputException("Restaurant name cannot be empty");
	        }

	        if (!StringUtils.hasText(restaurant.getAddress())) {
	            throw new InvalidInputException("Restaurant address cannot be empty");
	        }
	    }


	 

	    private void validateDeliveryPartner(DeliveryPartner deliveryPartner) {
	        if (!StringUtils.hasText(deliveryPartner.getName())) {
	            throw new InvalidInputException("Delivery partner name cannot be empty");
	        }

	        if (!StringUtils.hasText(deliveryPartner.getPhoneNumber())) {
	            throw new InvalidInputException("Delivery partner phone number cannot be empty");
	        }   
	    }
	    
	    private void validateOrder(Order order) {
	        if (order.getRestaurantId() == null || restaurants.get(order.getRestaurantId()) == null) {
	            throw new NotFoundException("Restaurant not found");
	        }

	        if (order.getCustomerId() == null || customers.get(order.getCustomerId()) == null) {
	            throw new NotFoundException("Customer not found");
	        }

	        if (order.getDeliveryPartnerId() != null && deliveryPartners.get(order.getDeliveryPartnerId()) == null) {
	            throw new NotFoundException("Delivery partner not found");
	        }

	        if (order.getItems() == null || order.getItems().isEmpty()) {
	            throw new InvalidInputException("Order must have at least one item");
	        }

	        if (!validStatus.contains(order.getOrderStatus())) {
	            throw new InvalidInputException("Invalid order status");
	        }
	    }

	
		public List<Customer> getAllCustomers() {
			
			Collection<Customer> values = customers.values();
			List<Customer> customers = new ArrayList<>(values);
			
			return customers;
			
		}
	
}
