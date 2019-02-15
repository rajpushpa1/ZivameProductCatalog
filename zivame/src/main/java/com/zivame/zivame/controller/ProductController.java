package com.zivame.zivame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zivame.zivame.exception.ProductException;
import com.zivame.zivame.model.Product;
import com.zivame.zivame.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@CrossOrigin
	@PostMapping("/saveproduct")
	public  ResponseEntity<Product> saveEmployee(@RequestBody Product product) throws ProductException {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/getallproducts")
	public ResponseEntity<Iterable<Product>> getAllProduct() throws ProductException {
		return new ResponseEntity<Iterable<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping(value="/deleteproduct/{productID}")
	public ResponseEntity<String> deleteTicket(@PathVariable("productID")int productID) throws ProductException{
		productService.deleteProduct(productID);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/getproduct/{type}")
	public ResponseEntity<Product> getProductByType(@PathVariable String type) throws ProductException {
		return new ResponseEntity<Product>(productService.getProductByType(type), HttpStatus.OK);
	}

}
