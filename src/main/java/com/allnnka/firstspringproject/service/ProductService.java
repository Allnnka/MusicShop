package com.allnnka.firstspringproject.service;


import com.allnnka.firstspringproject.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public interface ProductService {
    void save(Product product);
    List<Product> findAll();

}
