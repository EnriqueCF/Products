package com.example.demo.api.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice  extends ResponseEntityExceptionHandler {

	/**
	 * Handler ProductsNotAvailableException
	 * @param ex
	 * @return
	 */
	@ExceptionHandler({ProductsNotAvailableException.class})
	public ResponseEntity<ApiError> handlerProductsNotAvailable(RuntimeException ex) {
		ApiError errorBody = ApiError.builder()
				.status(HttpStatus.NOT_FOUND)
				.date(LocalDateTime.now())
				.message(ex.getMessage())
				.build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(errorBody);
	}
	

	/**
	 * Handler other exceptions
	 * @param exception
	 * @param body
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError errorBody = ApiError.builder()
			.status(status)
			.date(LocalDateTime.now())
			.message(ex.getMessage())
			.build();

		return ResponseEntity.status(status)
				.headers(headers)
				.body(errorBody);
	}

}
