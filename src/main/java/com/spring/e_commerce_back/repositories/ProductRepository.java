package com.spring.e_commerce_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.e_commerce_back.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
