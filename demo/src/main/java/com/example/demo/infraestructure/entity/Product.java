package com.example.demo.infraestructure.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Product {
	
	@Id
	private Integer id;
	private Integer sequence;
}
