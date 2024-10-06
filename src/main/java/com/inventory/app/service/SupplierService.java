package com.inventory.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventory.app.models.Supplier;
import com.inventory.app.repositories.SupplierRepository;

import jakarta.transaction.Transactional;

@Service
public class SupplierService {

	private final SupplierRepository supplierRepository;

	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	@Transactional
	public Supplier save(Supplier supplier) {
		return this.supplierRepository.save(supplier);
	}

	@Transactional
	public void deleteById(Long id) {
		this.supplierRepository.deleteById(id);
	}

	@Transactional
	public Optional<Supplier> findById(Long id) {
		return this.supplierRepository.findById(id);
	}

	@Transactional
	public List<Supplier> findAll() {
		return this.supplierRepository.findAll();
	}

}
