package com.masairevision.revision1.services;

import com.masairevision.revision1.entity.Customer;
import com.masairevision.revision1.entity.Order;

public interface CustomerService {

     void addCustomer(Customer customer);

    void updateCustomer(Customer customer,Integer cusId);

    void deleteCustomer(Integer cusId);

    void makeOrder(Integer cusId, Order order);

    Customer getCustomerbyEmail(String email);
}
