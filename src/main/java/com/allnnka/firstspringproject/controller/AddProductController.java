package com.allnnka.firstspringproject.controller;

import com.allnnka.firstspringproject.model.Product;
import com.allnnka.firstspringproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/addProduct")
    public String getProduct(Product product) {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(Product product)
    {
        productService.save(product);
        return("redirect:/");
    }
}
