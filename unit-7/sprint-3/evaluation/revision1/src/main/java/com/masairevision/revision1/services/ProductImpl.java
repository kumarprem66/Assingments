package com.masairevision.revision1.services;

import com.masairevision.revision1.entity.Product;
import com.masairevision.revision1.exception.ProductAlreadyExistException;
import com.masairevision.revision1.exception.ProductNotFoundException;
import com.masairevision.revision1.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Override
    public void addProduct(Product product) {

        if(product==null) throw new NullPointerException("product is null");
        Optional<Product> product1  = productRepo.findById(product.getProductId());
        if(product1.isPresent()) throw new ProductAlreadyExistException("product with this id is already exist");

        productRepo.save(product);

        log.info("product added successfully");
    }

    @Override
    public void updateProduct(Product product, Integer proId) {

        if(product==null) throw new NullPointerException("product is null");
        Optional<Product> product1  = productRepo.findById(proId);
        if(product1.isEmpty()) throw new ProductNotFoundException("product with this id  does not exist");

        Product product2 = product1.get();
        product2.setProductName(product.getProductName());
        product2.setDesc(product.getDesc());
        product2.setCategory(product.getCategory());
        product2.setPrice(product.getPrice());
        productRepo.save(product2);

        log.info("product updated successfully");

    }

    @Override
    public void deleteProduct(Integer proId) {

        Optional<Product> product1  = productRepo.findById(proId);
        if(product1.isEmpty()) throw new ProductNotFoundException("product with this id is not exist");

        productRepo.delete(product1.get());

        log.info("product deleted successfully");
    }


}
