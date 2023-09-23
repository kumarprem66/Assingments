package com.masairevision.revision1.services;

import com.masairevision.revision1.entity.Customer;
import com.masairevision.revision1.entity.Order;

import java.util.List;


public interface OrderService {


    public List<Order> showAllOrders(Integer cusId);
    void updateOrderStatus(Order order,Integer ordId);

    void cancelOrder(Integer ordId);
}
