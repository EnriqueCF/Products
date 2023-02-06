package com.example.demo.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.core.domain.ProductDomain;
import com.example.demo.core.mappers.ProductDomainMapper;
import com.example.demo.core.service.DefaultProductService;
import com.example.demo.infraestructure.entity.Product;
import com.example.demo.infraestructure.entity.Size;
import com.example.demo.infraestructure.entity.Stock;
import com.example.demo.infraestructure.repository.SizeRepository;

@ExtendWith(SpringExtension.class)
class DefaultProductServiceTests {

	@InjectMocks
	private DefaultProductService service;

	@Mock
	private ProductDomainMapper productMapper;

	@Mock
	private SizeRepository sizeRepository;

	@Test
	@DisplayName("Recupera un producto con stock")
	void givenProcductWhenGetAvailableThenReturnList() {
		// Given
		List<Size> sizes = new ArrayList<>();
		Product product1 = Product.builder().id(1).sequence(10).build();
		Stock stock11 = Stock.builder().sizeId(11).quantity(0).build();
		Stock stock12 = Stock.builder().sizeId(12).quantity(0).build();
		Stock stock13 = Stock.builder().sizeId(13).quantity(0).build();
		Size size11 = Size.builder().id(11).special(false).backSoon(true).product(product1).stock(stock11).build();
		Size size12 = Size.builder().id(12).special(false).backSoon(false).product(product1).stock(stock12).build();
		Size size13 = Size.builder().id(13).special(false).backSoon(true).product(product1).stock(stock13).build();
		sizes.add(size13);
		sizes.add(size12);
		sizes.add(size11);

		ProductDomain productDomain = ProductDomain.builder().id(1).sequence(10).build();

		// When
		when(sizeRepository.findAll()).thenReturn(sizes);
		when(productMapper.entityToDomain(product1)).thenReturn(productDomain);

		// Then
		List<ProductDomain> productos = service.getAvailableProducts();

		assertThat(productos.get(0).getId()).isEqualTo(1);
		assertThat(productos.get(0).getSequence()).isEqualTo(10);
	}

	@Test
	@DisplayName("Repositorio no devuelve ningun registro")
	void givenProductWhenGetAvailableThenReturnEmptyList() {
		// Given
		List<Size> sizes = new ArrayList<>();

		// When
		when(sizeRepository.findAll()).thenReturn(sizes);

		// Then
		List<ProductDomain> productos = service.getAvailableProducts();

		assertThat(productos).isEmpty();
	}
	
	@Test
	@DisplayName("Lista de productos con tipo especial")
	void givenProcductWhenGetSpecialProductsThenReturnList() {
		// Given
		List<Size> sizes = new ArrayList<>();
		Product product1 = Product.builder().id(1).sequence(10).build();
		Stock stock11 = Stock.builder().sizeId(11).quantity(0).build();
		Stock stock12 = Stock.builder().sizeId(12).quantity(0).build();
		Stock stock13 = Stock.builder().sizeId(13).quantity(0).build();
		Size size11 = Size.builder().id(11).special(false).backSoon(true).product(product1).stock(stock11).build();
		Size size12 = Size.builder().id(12).special(false).backSoon(false).product(product1).stock(stock12).build();
		Size size13 = Size.builder().id(13).special(true).backSoon(true).product(product1).stock(stock13).build();
		sizes.add(size13);
		sizes.add(size12);
		sizes.add(size11);

		ProductDomain productDomain = ProductDomain.builder().id(1).sequence(10).build();

		// When
		when(sizeRepository.findAll()).thenReturn(sizes);
		when(productMapper.entityToDomain(product1)).thenReturn(productDomain);

		// Then
		List<ProductDomain> productos = service.getAvailableProducts();

		assertThat(productos.get(0).getId()).isEqualTo(1);
		assertThat(productos.get(0).getSequence()).isEqualTo(10);
	}
}
