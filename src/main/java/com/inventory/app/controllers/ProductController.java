package com.inventory.app.controllers;

import java.util.List;
import java.util.Optional;

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
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product> product = this.productService.findById(id);
		
		if (product.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(product.get());
	}
	
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product product) {
		product = this.productService.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable Long id) {
		this.productService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
