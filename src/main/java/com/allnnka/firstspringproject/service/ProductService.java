package com.allnnka.firstspringproject.service;


import com.allnnka.firstspringproject.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void save(Product product);
    List<Product> findAll();
}
