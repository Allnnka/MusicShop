package com.allnnka.firstspringproject.repository;

import com.allnnka.firstspringproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByproductName(String productName);
}
