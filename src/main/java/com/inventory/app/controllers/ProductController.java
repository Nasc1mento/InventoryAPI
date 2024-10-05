package com.inventory.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.app.models.Product;
import com.inventory.app.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = this.productService.findAll();
		return ResponseEntity.status(200).body(products);
	}
	
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product body) {
		System.out.println(body);
		Product product = this.productService.save(body);
		return ResponseEntity.status(200).body(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable Long id) {
		this.productService.deleteById(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
}
