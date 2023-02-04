package com.example.demo.core.service;

import java.util.List;

import com.example.demo.core.domain.ProductDomain;

public interface ProductService {

	/**
	 * Get all the products with stock
	 * 
	 * @return
	 */
	List<ProductDomain> getAvailableProducts();
}
