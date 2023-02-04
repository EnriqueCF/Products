package com.example.demo.core.mappers;

import org.mapstruct.Mapper;

import com.example.demo.api.model.ProductResource;
import com.example.demo.core.domain.ProductDomain;

@Mapper
public interface ProductDomainMapper {

	ProductResource domainToResource(ProductDomain domain);
}
