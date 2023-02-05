package com.example.demo.api.server;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.api.model.ProductResource;
import com.example.demo.core.domain.ProductDomain;
import com.example.demo.core.mappers.ProductDomainMapper;
import com.example.demo.core.service.ProductService;

@WebMvcTest(DefaultProductApiController.class)
class DefaultProductApiControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProductService productService;
	@MockBean
	private ProductDomainMapper productMapper;
	
	@Test
	void givenProductsWhenGetAvailableThenReturnListOfIds() throws Exception {		
		// Given
		
		List<ProductDomain> products = new ArrayList<>();
		ProductDomain product1 = ProductDomain.builder().id(1).sequence(10).build();
		ProductDomain product2 = ProductDomain.builder().id(5).sequence(6).build();
		ProductDomain product3 = ProductDomain.builder().id(3).sequence(13).build();
		products.add(product3);
		products.add(product2);
		products.add(product1);

		ProductResource resource1 = ProductResource.builder().id(1).sequence(10).build();
		ProductResource resource2 = ProductResource.builder().id(5).sequence(6).build();
		ProductResource resource3 = ProductResource.builder().id(3).sequence(13).build();

		// When

		when(productService.getAvailableProducts()).thenReturn(products);
		when(productMapper.domainToResource(product1)).thenReturn(resource1);
		when(productMapper.domainToResource(product2)).thenReturn(resource2);
		when(productMapper.domainToResource(product3)).thenReturn(resource3);

		// Then
		
		mvc.perform(get("/products/available")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
		        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
		        .andExpect(jsonPath("$[0]", is(5)))
		        .andExpect(jsonPath("$[1]", is(1)))
		        .andExpect(jsonPath("$[2]", is(3)));
	}
}
