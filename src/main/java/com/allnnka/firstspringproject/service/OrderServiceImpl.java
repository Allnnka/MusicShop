package com.allnnka.firstspringproject.service;

import com.allnnka.firstspringproject.model.Order;
import com.allnnka.firstspringproject.repository.OrderRepository;
import com.allnnka.firstspringproject.repository.ProductRepository;

import java.time.LocalDate;

public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}
