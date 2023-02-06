package com.example.demo.infraestructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Stock {
	@Id
	@Column(name = "SIZEID")
	private Integer sizeId;
	private Integer quantity;
}