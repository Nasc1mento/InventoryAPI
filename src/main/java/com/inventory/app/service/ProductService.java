package com.inventory.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventory.app.models.Product;
import com.inventory.app.models.Supplier;
import com.inventory.app.repositories.ProductRepository;
import com.inventory.app.repositories.SupplierRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final SupplierRepository supplierRepository;
	
	public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository) {
		this.productRepository = productRepository;
		this.supplierRepository = supplierRepository;
	}
	
	@Transactional
	public Product save(Product product) {
		
		Optional<Supplier> supplier;
		supplier = this.supplierRepository.findById(product.getSupplier().getId());
		
		if (supplier.isEmpty())
			throw new RuntimeException("Supplier not found");
		
		product.setSupplier(supplier.get());
		return this.productRepository.save(product);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.productRepository.findById(id);
	}
	
	@Transactional
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}
	
	@Transactional
	public Optional<Product> findById(Long id) {
		return this.productRepository.findById(id);
	}
}
