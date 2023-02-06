package com.example.demo.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infraestructure.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Integer>{

}
