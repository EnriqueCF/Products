package com.example.demo.infraestructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class Size {
	
	@Id
	private Integer id;
		
	@Column(name = "BACKSOON")
	private boolean backSoon;
	
	private boolean special;
	
	@OneToOne
	@JoinColumn(name = "PRODUCTID")
	private Product product;
	
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName="SIZEID")
	private Stock stock;
}
