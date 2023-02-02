package com.example.demo.api.server;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class DefaultProductApiController implements ProductApiController {

	/**
	 * Get available products (with stock)
	 * 
	 * @return list of ids
	 */
	@Override
	@GetMapping("/available")
	public ResponseEntity<List<Integer>> getAvailableProducts() {
		List<Integer> result = Arrays.asList(5, 1, 3);
		return ResponseEntity.ok(result);
	}
}
