package com.example.demo.core.mappers;

import org.mapstruct.Mapper;

import com.example.demo.api.model.ProductResource;
import com.example.demo.core.domain.ProductDomain;
import com.example.demo.infraestructure.entity.Product;

@Mapper
public interface ProductDomainMapper {

	/**
	 * Domain to resource
	 * @param domain
	 * @return
	 */
	ProductResource domainToResource(ProductDomain domain);
	
	/**
	 * Entity to domain object
	 * @param entity
	 * @return
	 */
	ProductDomain entityToDomain(Product entity);
}
