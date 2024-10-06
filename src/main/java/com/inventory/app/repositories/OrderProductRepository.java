package com.inventory.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.app.models.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
