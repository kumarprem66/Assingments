package com.masaischool.swiggy3.controller;

import com.masaischool.swiggy3.entity.*;
import com.masaischool.swiggy3.services.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;



    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){

        List<Customer> customers = deliveryService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/deliveryPartner")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDeliveryPartner(@RequestBody @Valid DeliveryPartner deliveryPartner){
        deliveryService.addDeliveryPartner(deliveryPartner);
    }

    @PostMapping("/customersP")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody @Valid Customer customer){
        deliveryService.addCustomer(customer);
    }

    @PostMapping("/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody @Valid Restaurant restaurant) {
        deliveryService.addRestaurant(restaurant);
    }

    @PostMapping("/orders/{cusId}/{resId}/{dpartId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody @Valid Orders order1 , @PathVariable("cusId") Integer cus , @PathVariable Integer resId , @PathVariable Integer dpartId) {

        deliveryService.placingOrder(cus , resId , dpartId , order1);
    }

   @PatchMapping("/orders/{orderId}/status/{orderStatus}")
   public void updateOrderStatus(@PathVariable Integer orderId, @PathVariable OrderStatus orderStatus){
        deliveryService.updateOrderStatus(orderId,orderStatus);
    }

    @GetMapping("/customer/{customerId}/orders")
    public List<Orders> fetchCustomerOrderHistory(@PathVariable Integer customerId){
        return deliveryService.fetchCustomerOrderHistory(customerId);
    }

    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){

        System.out.println(auth); // this Authentication object having Principle object details


        System.out.println(auth.getDetails().toString());

        Customer customer= deliveryService.getCustomerDetailsByEmail(auth.getName());

        return new ResponseEntity<>(customer.getName()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/signInRes")
    public ResponseEntity<String> getLoggedInRestaurantDetailsHandler(Authentication auth){

        System.out.println(auth); // this Authentication object having Principle object details


        System.out.println(auth.getDetails().toString());

        Restaurant restaurant= deliveryService.getRestaurant(auth.getName());

        return new ResponseEntity<>(restaurant.getName()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }
}
