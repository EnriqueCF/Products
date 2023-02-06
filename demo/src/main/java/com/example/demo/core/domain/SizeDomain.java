package com.example.demo.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SizeDomain {
	private Integer id;
	private ProductDomain product;
	private boolean backSoon;
	private boolean special;
}