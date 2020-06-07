package com.allnnka.firstspringproject.service;

import com.allnnka.firstspringproject.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public Iterable<Order> getAllOrders();
    public Order create(Order order);
    public void update(Order order);
}
