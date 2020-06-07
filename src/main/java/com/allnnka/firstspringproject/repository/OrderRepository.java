package com.allnnka.firstspringproject.repository;

import com.allnnka.firstspringproject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
