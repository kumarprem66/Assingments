package com.masairevision.revision1.services;

import com.masairevision.revision1.entity.Product;
import com.masairevision.revision1.exception.ProductAlreadyExistException;
import com.masairevision.revision1.exception.ProductNotFoundException;
import com.masairevision.revision1.repository.CustomerRepo;
import com.masairevision.revision1.repository.OrderRepo;
import com.masairevision.revision1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCatalogImpl implements ProductCatalogService{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Product getProductById(Integer proId) {

        Optional<Product> product1  = productRepo.findById(proId);
        if(product1.isEmpty()) throw new ProductNotFoundException("product with this id not exist");


        return product1.get();
    }

    @Override
    public List<Product> getProductList() {

        List<Product> productList = productRepo.findAll();
        if(!productList.isEmpty()) return productList;

        return null;
    }

    @Override
    public Product searchProductByName(String name) {
        Optional<Product> product1  = productRepo.findByName(name);
        if(product1.isEmpty()) throw new ProductNotFoundException("product with this name not exist");


        return product1.get();
    }
}
