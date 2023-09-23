package com.masairevision.revision1.services;

import com.masairevision.revision1.entity.Customer;
import com.masairevision.revision1.entity.Order;
import com.masairevision.revision1.entity.Product;

public interface ProductService {

    void addProduct(Product product);

    void updateProduct(Product product, Integer proId);

    void deleteProduct(Integer proId);

}
