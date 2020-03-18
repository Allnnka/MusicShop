package com.allnnka.firstspringproject.controller;

import com.allnnka.firstspringproject.model.Product;
import com.allnnka.firstspringproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.http.HttpHeaders;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    public static String uploadDirectory= System.getProperty("user.dir")+"/src/main/resources/static/uploads";

    @GetMapping("/addProduct")
    public String getProduct(Product product) {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(final @RequestParam("imageFile") MultipartFile imageFile , Product product)
    {
        try{
          String fileName = imageFile.getOriginalFilename();
          String filePath= Paths.get(uploadDirectory, fileName).toString();
          String fileType= imageFile.getContentType();
          long size=imageFile.getSize();
          String fileSize= String.valueOf(size);
          Timestamp curruntTimestamp = new Timestamp(System.currentTimeMillis());

          //Save the file locally
            BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            stream.write(imageFile.getBytes());
            stream.close();
            product.setFileName(fileName);
            product.setFilePath(filePath);
            product.setFileType(fileType);
            product.setFileSize(fileSize);
            product.setCreatedDate(curruntTimestamp);
            productService.save(product);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return("redirect:/");
    }

}
