package com.inventory.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventory.app.models.Order;
import com.inventory.app.models.OrderProduct;
import com.inventory.app.models.Product;
import com.inventory.app.repositories.OrderProductRepository;
import com.inventory.app.repositories.OrderRepository;
import com.inventory.app.repositories.ProductRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;

	public OrderService(OrderRepository orderRepository, OrderProductRepository orderProductRepository,
			ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}

	public Order save(Order order) {
		for (OrderProduct orderProduct : order.getOrderProducts()) {
			Optional<Product> product = productRepository.findById(orderProduct.getProduct().getId());
			if (product.isEmpty())
				throw new IllegalArgumentException("Product not found");

			orderProduct.setProduct(product.get());
			orderProduct.setOrder(order);
		}

		return this.orderRepository.save(order);
	}

	public void deleteById(Long id) {
		this.orderRepository.deleteById(id);
	}

	public List<Order> findAll() {
		return this.orderRepository.findAll();
	}

	public Optional<Order> findById(Long id) {
		return this.orderRepository.findById(id);
	}

}
