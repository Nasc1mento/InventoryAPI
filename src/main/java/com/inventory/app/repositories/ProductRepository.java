package com.inventory.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.app.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
