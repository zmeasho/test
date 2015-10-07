package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
      private ProductRepository productRepository;
	
		
	public void processOredr(String productId, int count) {
		// TODO Auto-generated method stub
		Product ProductbyId = productRepository.getProductID(productId);
		if(ProductbyId.getUnitsInStock()< count){
			throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ ProductbyId.getUnitsInStock());
		}
		ProductbyId.setUnitsInStock(ProductbyId.getUnitsInStock()- count);
	}
		
	}
	
	


