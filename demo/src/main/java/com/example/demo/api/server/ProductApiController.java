package com.example.demo.api.server;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ProductApiController {

	/**
	 * Get available products (with stock)
	 * 
	 * @return list of ids
	 */
	ResponseEntity<List<Integer>> getAvailableProducts();
}
