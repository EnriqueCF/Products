package com.example.demo.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductsNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1438047260809820991L;

	public ProductsNotAvailableException() {
		super("No existen productos en stock.");
	}
}