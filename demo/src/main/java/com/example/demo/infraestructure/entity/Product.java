package com.example.demo.infraestructure.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	private Integer id;
	private Integer sequence;
}
