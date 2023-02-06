package com.example.demo.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockDomain {

	private Integer sizeId;
	private Integer quantity;
}
