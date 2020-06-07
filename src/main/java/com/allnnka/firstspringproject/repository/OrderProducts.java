package com.allnnka.firstspringproject.repository;

import com.allnnka.firstspringproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProducts  extends JpaRepository<OrderProducts, Long> {

}
