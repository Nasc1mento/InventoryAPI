package com.inventory.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.app.models.Product;
import com.inventory.app.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Transactional
	public List<Product> findAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	@Transactional
	public Product insert(Product product) {
		return this.productRepository.save(product);
	}
	
}
