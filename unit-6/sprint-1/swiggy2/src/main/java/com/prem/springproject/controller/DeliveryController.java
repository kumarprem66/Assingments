package com.prem.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prem.springproject.entities.Customer;
import com.prem.springproject.entities.DeliveryPartner;
import com.prem.springproject.entities.OrderStatus;
import com.prem.springproject.entities.Orders;
import com.prem.springproject.entities.Restaurant;
import com.prem.springproject.services.DeliveryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class DeliveryController {

	
	@Autowired
	private DeliveryService deliveryService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		List<Customer> customers = deliveryService.getAllCustomers();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	@PostMapping("/customers")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCustomer(@RequestBody @Valid Customer customer) {
		deliveryService.addCustomer(customer);
	}
	
	
	@PostMapping("/deliveryPartner")
	@ResponseStatus(HttpStatus.CREATED)
	public void addDeliveryPartner(@RequestBody @Valid DeliveryPartner deliveryPartner) {
		deliveryService.addDeliveryPartner(deliveryPartner);
	}
	
	
	@PostMapping("/restaurant")
	@ResponseStatus(HttpStatus.CREATED)
	public void addRestaurant(@RequestBody @Valid Restaurant restaurant) {
		deliveryService.addRestaurant(restaurant);
	}
	
	 @PostMapping("/order/{cusId}/{resId}/{dpartId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody @Valid Orders order , @PathVariable("cusId") Integer cus , @PathVariable Integer resId , @PathVariable Integer dpartId) {
    
        deliveryService.placeOrder(cus , resId , dpartId , order );
    }
	
	@PatchMapping("/orders/{orderId}/deliveryPartner/{deliveryPartnerId}/")
	public void assignDeliveryPartner(@PathVariable Integer orderId,@PathVariable Integer deliveryPartnerId) {
		
		deliveryService.assignDeliveryPartner(orderId, deliveryPartnerId);
	}
	

    @PatchMapping("/order/{orderId}/status/{orderStatus}")
    public void updateOrderStatus(@PathVariable Integer orderId, @PathVariable OrderStatus orderStatus) {
        deliveryService.updateOrderStatus(orderId, orderStatus);
    }

    @GetMapping("/customer/{customerId}/orders")
    public List<Orders> fetchCustomerOrderHistory(@PathVariable Integer customerId) {
        return deliveryService.fetchCustomerOrderHistory(customerId);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
