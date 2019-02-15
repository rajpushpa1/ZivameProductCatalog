package com.zivame.zivame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zivame.zivame.exception.ProductException;
import com.zivame.zivame.model.Product;
import com.zivame.zivame.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	
	public Product saveProduct(Product product) throws ProductException {
		return repository.save(product);
	}
	
	
	public Iterable<Product> getAllProducts() throws ProductException {
		return repository.findAll();
	}
	
	public String deleteProduct(int productId)throws ProductException {
		repository.deleteById(productId);
		return "deletedSuccessfully";
	}
	
	
	public Product getProductByType(String prodType) throws ProductException {
		return repository.findByType(prodType);
	}

}
