package com.inventory.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.app.models.Product;
import com.inventory.app.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = this.productService.findAll();
		return ResponseEntity.status(200).body(products);
	}
	
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product body) {
		Product product = this.productService.insert(body);
		return ResponseEntity.status(200).body(product);
	}
}
