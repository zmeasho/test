package com.packt.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllproduct();
	List<Product> getProductsByCategory(String category);
    Product getproductByid( String productID);
    Set<Product> getProductsByFilter(Map<String,
    		List<String>> filterParams);
    void addProduct(Product product);
}
