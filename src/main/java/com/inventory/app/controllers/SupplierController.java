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

import com.inventory.app.models.Supplier;
import com.inventory.app.service.SupplierService;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierController {

	private final SupplierService supplierService;
	
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
		
	}
	
	@PostMapping
	public ResponseEntity<Supplier> create(@RequestBody Supplier supplier) {
		supplier = this.supplierService.save(supplier);
		return ResponseEntity.status(200).body(supplier);
	}
	
	@GetMapping
	public ResponseEntity<List<Supplier>> findAll() {
		List<Supplier> suppliers = this.supplierService.findAll();
		return ResponseEntity.status(200).body(suppliers);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Supplier> deleteById(@PathVariable Long id) {
		this.supplierService.deleteById(id);
		return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);
	}

}
