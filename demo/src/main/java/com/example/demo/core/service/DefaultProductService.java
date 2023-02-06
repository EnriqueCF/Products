package com.example.demo.core.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.core.domain.ProductDomain;
import com.example.demo.core.mappers.ProductDomainMapper;
import com.example.demo.infraestructure.entity.Product;
import com.example.demo.infraestructure.entity.Size;
import com.example.demo.infraestructure.repository.SizeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

	private Predicate<Size> specialSize = Size::isSpecial;
	private Predicate<Size> stock = size -> size.isBackSoon()
			|| (size.getStock() != null && size.getStock().getQuantity() > 0);

	private final SizeRepository sizeRepository;
	private final ProductDomainMapper productMapper;

	@Override
	public List<ProductDomain> getAvailableProducts() {
		List<ProductDomain> availableProducts = new ArrayList<>();
		List<Size> sizes = sizeRepository.findAll();

		if (!sizes.isEmpty()) {
			Map<Product, List<Size>> sizesByProductId = sizes.stream()
					.collect(Collectors.groupingBy(Size::getProduct));
			
			List<Product> results = sizesByProductId.entrySet().stream()
					.filter(e -> hasAnyProductWithStock(e.getValue()))
					.map(Entry::getKey)
					.collect(Collectors.toList());
			
			availableProducts = results.stream()
					.map(productMapper::entityToDomain)
					.collect(Collectors.toList());
		}

		return availableProducts;
	}

	private boolean hasAnyProductWithStock(List<Size> sizes) {
		boolean hasStock = false;

		boolean hasSpecialSizes = sizes.stream().anyMatch(specialSize);

		if (hasSpecialSizes) {
			Set<Size> normal = new HashSet<>();
			Set<Size> special = new HashSet<>();
			sizes.stream().forEach(size -> {
				if (stock.test(size)) {
					if (size.isSpecial()) {
						special.add(size);
					} else {
						normal.add(size);
					}
				}
			});

			hasStock = !normal.isEmpty() && !special.isEmpty();
		} else {
			hasStock = sizes.stream().anyMatch(stock);
		}
		return hasStock;
	}

}
