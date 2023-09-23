package com.masairevision.revision1.services;

import com.masairevision.revision1.entity.Customer;
import com.masairevision.revision1.entity.Order;
import com.masairevision.revision1.exception.CustomerAlreadyExist;
import com.masairevision.revision1.exception.CustomerNotExist;
import com.masairevision.revision1.exception.ProductAlreadyExistException;
import com.masairevision.revision1.repository.CustomerRepo;
import com.masairevision.revision1.repository.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void addCustomer(Customer customer) {

        if(customer==null) throw new NullPointerException("customer is null");
        Optional<Customer> customer1  = customerRepo.findById(customer.getCustomerId());
        if(customer1.isPresent()) throw new CustomerAlreadyExist("customer with this id is already exist");

        customerRepo.save(customer);

        log.info("customer added successfully");

    }

    @Override
    public void updateCustomer(Customer customer, Integer cusId) {

        if(customer==null) throw new NullPointerException("customer is null");
        Optional<Customer> customer1  = customerRepo.findById(customer.getCustomerId());
        if(customer1.isEmpty()) throw new CustomerNotExist("customer with this id not exist");

        Customer cus = customer1.get();
        cus.setCustomerName(customer.getCustomerName());
        cus.setCity(customer.getCity());

        cus.setRole(customer.getRole());
        customerRepo.save(cus);

        log.info("customer updated successfully");
    }

    @Override
    public void deleteCustomer(Integer cusId) {

        Optional<Customer> customer1  = customerRepo.findById(cusId);
        if(customer1.isEmpty()) throw new CustomerNotExist("customer with this id not exist");

        Customer customer = customer1.get();
        customer.setStatus(true);
        customerRepo.save(customer);

        log.info("customer deleted successfully");
    }

    @Override
    public void makeOrder(Integer cusId, Order order) {

        if(order==null) throw new NullPointerException("order is null");
        Optional<Order> order1  = orderRepo.findById(order.getOrderId());
        Optional<Customer> customer  = customerRepo.findById(cusId);
        if(order1.isPresent()) throw new ProductAlreadyExistException("order with this id is already exist");
        if(customer.isEmpty()) throw new CustomerNotExist("Customer with this id is not exist");

        customer.get().getOrders().add(order);
        customerRepo.save(customer.get());
        orderRepo.save(order);


        log.info("ordered successfully");
    }

    @Override
    public Customer getCustomerbyEmail(String email) {
       return customerRepo.findByEmail(email).get();
    }
}
