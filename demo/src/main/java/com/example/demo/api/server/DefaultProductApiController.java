package com.example.demo.api.server;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.error.ProductsNotAvailableException;
import com.example.demo.api.model.ProductResource;
import com.example.demo.core.domain.ProductDomain;
import com.example.demo.core.mappers.ProductDomainMapper;
import com.example.demo.core.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class DefaultProductApiController implements ProductApiController {

	private final ProductService productService;
	private final ProductDomainMapper productMapper;

	/**
	 * Get available products (with stock)
	 * 
	 * @return list of ids
	 */
	@Override
	@GetMapping("/available")
	public ResponseEntity<List<Integer>> getAvailableProducts() {
		Optional<List<ProductDomain>> products = Optional.ofNullable(productService.getAvailableProducts());

		if (products.isEmpty()) {
			throw new ProductsNotAvailableException();
		} else {
			List<Integer> result = products.get().stream()
					.map(productMapper::domainToResource)
					.sorted(Comparator.comparing(ProductResource::getSequence))
					.map(ProductResource::getId)
					.collect(Collectors.toList());
			return ResponseEntity.ok(result);
		}
	}
}
