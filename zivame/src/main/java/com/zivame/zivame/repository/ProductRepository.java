package com.zivame.zivame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zivame.zivame.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByType(String type);

	Product findByProductId(int id);



}
