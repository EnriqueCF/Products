package com.example.demo.api.server;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DefaultProductApiController.class)
class DefaultProductApiControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void givenProductsWhenGetAvailableThenReturnListOfIds() throws Exception {		
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
