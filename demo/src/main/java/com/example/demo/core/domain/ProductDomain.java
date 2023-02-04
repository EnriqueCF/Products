package com.example.demo.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDomain {

	private Integer id;
	private Integer sequence;
}
