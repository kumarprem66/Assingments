package com.masairevision.revision1.controller;


import com.masairevision.revision1.entity.Customer;
import com.masairevision.revision1.entity.Order;
import com.masairevision.revision1.entity.Product;
import com.masairevision.revision1.entity.Role;
import com.masairevision.revision1.services.CustomerService;
import com.masairevision.revision1.services.OrderService;
import com.masairevision.revision1.services.ProductCatalogService;
import com.masairevision.revision1.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ECommerceController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCatalogService productCatalogService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/customerAdd")
    public ResponseEntity<String> registerCustomer(@RequestBody @Valid Customer customer){

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        customer.setRole(Role.valueOf("ROLE_"+customer.getRole().toString().toUpperCase()));


        customerService.addCustomer(customer);

        return new ResponseEntity<>("customer added ", HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer/{cusId}")

    public ResponseEntity<String> updateCustomer(@RequestBody @Valid  Customer customer, @PathVariable Integer cusId){


        customerService.updateCustomer(customer,cusId);

        return new ResponseEntity<>("customer updated ", HttpStatus.ACCEPTED);
    }

    @PutMapping("/deleteCustomer/{cusId}")

    public ResponseEntity<String> deleteCustomer( @PathVariable Integer cusId){


        customerService.deleteCustomer(cusId);

        return new ResponseEntity<>("customer deleted ", HttpStatus.ACCEPTED);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<String> addProductHandler(@RequestBody @Valid Product product){


        productService.addProduct(product);

        return new ResponseEntity<>("product added successfully ", HttpStatus.CREATED);
    }

    @PostMapping("/updateProduct/{proId}")
    public ResponseEntity<String> updateProductHandler(@RequestBody @Valid Product product,@PathVariable Integer proId){

        productService.updateProduct(product,proId);

        return new ResponseEntity<>("product updated successfully ", HttpStatus.ACCEPTED);
    }

    @PutMapping("/deleteProduct/{proId}")
    public ResponseEntity<String> deleteProductHandler(@PathVariable Integer proId){


        productService.deleteProduct(proId);

        return new ResponseEntity<>("product deleted successfully ", HttpStatus.CREATED);
    }


    @GetMapping("/showOrders/{cusId}")
    public ResponseEntity<List<Order>> showOrders(@PathVariable Integer cusId){


        List<Order> orders = orderService.showAllOrders(cusId);

        return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
    }


    @PutMapping("/updateOrders/{cusId}")
    public ResponseEntity<String> updateOrderStatusHandler(@RequestBody Order order,@PathVariable Integer cusId){


        orderService.updateOrderStatus(order,cusId);

        return new ResponseEntity<>("order updated successfully", HttpStatus.ACCEPTED);
    }


    @GetMapping("/cancelOrders/{cusId}")
    public ResponseEntity<String> cancelOrdersHandler(@PathVariable Integer cusId){


        orderService.cancelOrder(cusId);

        return new ResponseEntity<>("order cancelled", HttpStatus.ACCEPTED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){


        List<Product> productList = productCatalogService.getProductList();

        return new ResponseEntity<>(productList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{proId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer proId){


        Product product = productCatalogService.getProductById(proId);

        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
    }


    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){

        System.out.println(auth); // this Authentication object having Principle object details

        Customer customer=  customerService.getCustomerbyEmail(auth.getName());

        return new ResponseEntity<>(customer.getCustomerName()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }



}
