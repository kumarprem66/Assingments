package com.masairevision.revision1.services;

import com.masairevision.revision1.entity.Customer;
import com.masairevision.revision1.entity.Order;
import com.masairevision.revision1.entity.Product;
import com.masairevision.revision1.exception.CustomerNotExist;
import com.masairevision.revision1.exception.ProductAlreadyExistException;
import com.masairevision.revision1.exception.ProductNotFoundException;
import com.masairevision.revision1.repository.CustomerRepo;
import com.masairevision.revision1.repository.OrderRepo;
import com.masairevision.revision1.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderImpl implements OrderService{

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;



    @Override
    public List<Order> showAllOrders(Integer cusId) {
        Optional<Customer> customer  = customerRepo.findById(cusId);
        if(customer.isEmpty()) throw new CustomerNotExist("customer with this id does not exist");
        List<Order> orderList = customer.get().getOrders();
        if(!orderList.isEmpty()) return orderList;

        return null;
    }

    @Override
    public void updateOrderStatus(Order order, Integer ordId) {

        if(order==null) throw new NullPointerException("order is null");
        Optional<Order> order1  = orderRepo.findById(order.getOrderId());
        if(order1.isEmpty()) throw new ProductNotFoundException("order with this id does not exist");

        Order order2 = order1.get();
        order2.setProductStatus(order.getProductStatus());
        orderRepo.save(order2);

        log.info("order status updated successfully");

    }


    @Override
    public void cancelOrder(Integer ordId) {


        Optional<Order> order1  = orderRepo.findById(ordId);
        if(order1.isEmpty()) throw new ProductNotFoundException("order with this id does not exist");

        Order order2 = order1.get();
        order2.setStatus(true);
        orderRepo.save(order2);

        log.info("order deleted updated successfully");
    }
}
