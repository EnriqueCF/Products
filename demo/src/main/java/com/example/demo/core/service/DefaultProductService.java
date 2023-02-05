package com.example.demo.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.ProductDomain;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

	@Override
	public List<ProductDomain> getAvailableProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
