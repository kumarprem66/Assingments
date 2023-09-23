package com.masaischool.swiggy3.services;

import com.masaischool.swiggy3.entity.*;
import com.masaischool.swiggy3.exception.SwiggyException;

import java.util.List;

public interface DeliveryService {

     void addCustomer(Customer customer);
    void addRestaurant(Restaurant restaurant);

    void addDeliveryPartner(DeliveryPartner deliveryPartner);

    void placingOrder(Integer customerId, Integer resId, Integer devId, Orders orders
    );

    void assignDeliveryPartner(Integer orderId,Integer deliveryPartnerId);

    void updateOrderStatus(Integer orderId, OrderStatus newStatus);

     List<Orders> fetchCustomerOrderHistory(Integer customerId);

     List<Customer> getAllCustomers();

    Customer getCustomerDetailsByEmail(String email)throws SwiggyException;

    Restaurant getRestaurant(String name) throws SwiggyException;



}
