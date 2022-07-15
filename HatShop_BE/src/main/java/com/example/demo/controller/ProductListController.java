package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Products;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductListController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/sort")
    public List<Products> sort(@RequestParam(name="field") String field) {
      return  productService.getAllASC(field);
    }

//    @GetMapping(value = "/detailProduct/{id}")
//    public Products detailProduct(@PathVariable(name="id") int id) {
//        return productService.getProduct(id);
//    }

    @GetMapping(value = "/detailProduct/{id}")
    public ProductDTO detailProduct(@PathVariable(name="id") int id) {
        return productService.getProductDetail(id);
    }


}
