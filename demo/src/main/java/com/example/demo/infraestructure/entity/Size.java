package com.example.demo.infraestructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Size {
	
	@Id
	private Integer id;
	
//	@Column(name = "PRODUCTID")
//	private Integer productId;
	
	@Column(name = "BACKSOON")
	private boolean backSoon;
	
	private boolean special;
	
	@OneToOne
	@JoinColumn(name = "PRODUCTID")
	Product product;
	
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName="SIZEID")
	private Stock stock;
}
