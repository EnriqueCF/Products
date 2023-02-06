package com.example.demo.core.domain;

import lombok.Data;

@Data
public class SizeDomain {
	private Integer id;
	private ProductDomain product;
	private boolean backSoon;
	private boolean special;
}