package com.masairevision.revision1.services;

import com.masairevision.revision1.entity.Product;

import java.util.List;

public interface ProductCatalogService {

     Product getProductById(Integer proId);

     List<Product> getProductList();

     Product searchProductByName(String name);
}
