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

import com.inventory.app.models.Order;
import com.inventory.app.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	public final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody Order order) {
		System.out.println(order);
		order = this.orderService.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Optional<Order> order = this.orderService.findById(id);
		if (order.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(order.get());
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = this.orderService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Order> deleteById(@PathVariable Long id) {
		this.orderService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
