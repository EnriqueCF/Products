package com.example.demo.api.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResource {
	private Integer id;
	private Integer sequence;
}
