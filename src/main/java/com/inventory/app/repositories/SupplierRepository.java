package com.inventory.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.app.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
