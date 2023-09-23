package com.prem.springproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prem.springproject.entities.Customer;
import com.prem.springproject.entities.DeliveryPartner;
import com.prem.springproject.entities.OrderStatus;
import com.prem.springproject.entities.Orders;
import com.prem.springproject.entities.Restaurant;

import lombok.extern.slf4j.Slf4j;


public interface DeliveryService {

	public void addCustomer(Customer customer);
	
	public void addRestaurant(Restaurant restaurant);
	
	 public void addDeliveryPartner(DeliveryPartner deliveryPartner);
	 
	 public void placeOrder(Integer customerId , Integer resId , Integer devId ,Orders orders);
	 
	  public void assignDeliveryPartner(Integer orderId, Integer deliveryPartnerId);
	  
	  
	  public void updateOrderStatus(Integer orderId, OrderStatus newStatus);
	  

	    public List<Orders> fetchCustomerOrderHistory(Integer customerId);  
	    
	    public List<Customer> getAllCustomers();
}
