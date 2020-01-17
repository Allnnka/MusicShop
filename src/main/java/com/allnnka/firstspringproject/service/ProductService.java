package com.allnnka.firstspringproject.service;


import com.allnnka.firstspringproject.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    void save(Product product);
}
