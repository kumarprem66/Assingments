package com.masaischool.swiggy3.services;

import com.masaischool.swiggy3.entity.*;
import com.masaischool.swiggy3.exception.SwiggyException;
import com.masaischool.swiggy3.repository.CustomerRepository;
import com.masaischool.swiggy3.repository.DeliveryRepository;
import com.masaischool.swiggy3.repository.OrderRepository;
import com.masaischool.swiggy3.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DeliveryServiceImpl implements DeliveryService{

    @Autowired
    private CustomerRepository crepo;
    @Autowired
    private RestaurantRepository rRepo;
    @Autowired
    private DeliveryRepository dRepo;
    @Autowired
    private OrderRepository oRepo;


    @Override
    public void addCustomer(Customer customer) {

        if(customer == null) throw new SwiggyException("Swiggy is null");
        Optional<Customer> cus = crepo.findById(customer.getCustomerId());
        if(cus.isPresent()) throw new SwiggyException("Already present");
        crepo.save(customer);
        log.info("customer added ");
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {

        if(restaurant == null) throw new SwiggyException("Swiggy is null");
        Optional<Restaurant> res = rRepo.findById(restaurant.getRestaurantId());
        if(res.isPresent()) throw new SwiggyException("Already present");

        rRepo.save(restaurant);
    }

    @Override
    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {

        if(deliveryPartner == null) throw new SwiggyException("deliveryPartner is null");
        Optional<DeliveryPartner> dp = dRepo.findById(deliveryPartner.getDeliveryPartnerId());
        if(dp.isPresent()) throw new SwiggyException("Already present");

        dRepo.save(deliveryPartner);
    }

    @Override
    public void placingOrder(Integer customerId, Integer resId,Integer devId, Orders orders) {

        Optional<Customer> cus = crepo.findById(customerId);
        Optional<Restaurant> res = rRepo.findById(resId);
        Optional<DeliveryPartner> dp = dRepo.findById(devId);
        if(cus.isEmpty() || res.isEmpty() || dp.isEmpty() || orders == null) {
            throw new SwiggyException("Null value");
        }
        orders.setCustomer(cus.get());
        orders.setRestaurant(res.get());
        orders.setDeliveryPartner(dp.get());
        res.get().getOrders().add(orders);
        cus.get().getOrders().add(orders);
        dp.get().getOrders().add(orders);

        oRepo.save(orders);
    }

    @Override
    public void assignDeliveryPartner(Integer orderId, Integer deliveryPartnerId) {

        Optional<DeliveryPartner> dPart = dRepo.findById(deliveryPartnerId);
        Optional<Orders> orders = oRepo.findById(deliveryPartnerId);
        if(dPart.isEmpty() || orders.isEmpty()) throw new SwiggyException("null value");
        dPart.get().getOrders().add(orders.get());
        orders.get().setDeliveryPartner(dPart.get());
        oRepo.save(orders.get());
    }

    @Override
    public void updateOrderStatus(Integer orderId, OrderStatus newStatus) {

        Optional<Orders> order = oRepo.findById(orderId);
        if(order.isPresent() && order.get().getOrderStatus() == OrderStatus.DELIVERED)
            throw new SwiggyException("Cannot change the status of a delivered order");

        order.get().setOrderStatus(newStatus);
        oRepo.save(order.get());
    }

    @Override
    public List<Orders> fetchCustomerOrderHistory(Integer customerId) {
        Optional<Customer> cus = crepo.findById(customerId);
        if(cus.isEmpty()) throw new SwiggyException("null value");
        if(cus.get().getOrders().isEmpty()) throw new SwiggyException("no order");

        return cus.get().getOrders();
    }

    @Override
    public List<Customer> getAllCustomers() {
        Pageable pageable = PageRequest.of(0,5,Sort.by("name").ascending());
        List<Customer> customerList = crepo.findAll(pageable).getContent();
        if(customerList.isEmpty()) throw new SwiggyException("Empty customer list");

        return customerList;
    }
}
