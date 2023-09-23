package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.DeliveryPartner;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderStatus;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.DeliveryService;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;
    
    
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
    	
    	List<Customer> customers = deliveryService.getAllCustomers();
    	ResponseEntity<List<Customer>> allCustomers = new ResponseEntity<>(customers, HttpStatus.OK);
		return allCustomers;
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomer(@RequestBody Customer customer) {
        deliveryService.addCustomer(customer);
        return "Success";
    }

    @PostMapping("/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        deliveryService.addRestaurant(restaurant);
    }

    @PostMapping("/deliveryPartner")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner) {
        deliveryService.addDeliverPartner(deliveryPartner);
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody Order order) {
        deliveryService.placeOrder(order);
    }

    @PatchMapping("/order/{orderId}/deliveryPartner/{deliveryPartnerId}")
    public void assignDeliveryPartner(@PathVariable String orderId, @PathVariable String deliveryPartnerId) {
        deliveryService.assignDeliveryPartner(orderId, deliveryPartnerId);
    }

    
/**  
 * Sample Input :
 *   {
        "customerId": "customer1",
        "restaurantId": "restaurant1",
        "items": ["item1", "item2"],
        "orderStatus": "COOKING"
    }
**/
    @PatchMapping("/order/{orderId}/status/{orderStatus}")
    public void updateOrderStatus(@PathVariable String orderId, @PathVariable OrderStatus orderStatus) {
        deliveryService.updateOrderStatus(orderId, orderStatus);
    }

    @GetMapping("/customer/{customerId}/orders")
    public List<Order> fetchCustomerOrderHistory(@PathVariable String customerId) {
        return deliveryService.fetchCustomerOrderHistory(customerId);
    }
}
