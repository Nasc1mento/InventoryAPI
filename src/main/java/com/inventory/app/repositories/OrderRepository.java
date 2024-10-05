package com.inventory.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.app.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
