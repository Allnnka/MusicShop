package com.allnnka.firstspringproject.controller;

import com.allnnka.firstspringproject.model.Product;
import com.allnnka.firstspringproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products",productList);
        return "index";
    }


}
