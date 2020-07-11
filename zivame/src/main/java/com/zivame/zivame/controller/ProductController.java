
package com.zivame.zivame.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
//@RequestMapping("/api")
public class ProductController {

	private static final Logger logger = LogManager.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	
	@CrossOrigin
	@PostMapping("/saveproduct")
	public  ResponseEntity<Product> saveProduct(@RequestBody Product product) throws ProductException {
		
//		productService.saveProduct(product);

		logger.info("Inside saveProduct Mehthod ==>>>" + product.toString());
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/getallproduct")
	public ResponseEntity<Iterable<Product>> getAllProduct() throws ProductException {
		return new ResponseEntity<Iterable<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping(value="/deleteproduct/{productID}")
	public ResponseEntity<String> deleteTicket(@PathVariable("productID")int productID) throws ProductException{
		productService.deleteProduct(productID);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}

	@GetMapping("/getproductby/{type}")
	public ResponseEntity<Product> getProductByType(@PathVariable String type) throws ProductException {
		return new ResponseEntity<Product>(productService.getProductByType(type), HttpStatus.OK);
	}
	
	@GetMapping("/getproductby/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) throws ProductException {
		logger.info("Inside getProductById Mehthod ==>>>" + productService.getProductById(id));
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello-world";
	}

}
