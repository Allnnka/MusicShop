package com.allnnka.firstspringproject;

import com.allnnka.firstspringproject.controller.ProductController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

import static com.allnnka.firstspringproject.controller.ProductController.uploadDirectory;

@SpringBootApplication
public class FirstspringprojectApplication{
    public static void main(String[] args) throws Exception{
        new File(ProductController.uploadDirectory).mkdir();
        SpringApplication.run(FirstspringprojectApplication.class, args);
    }

}
