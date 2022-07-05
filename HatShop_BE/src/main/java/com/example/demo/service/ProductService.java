package com.example.demo.service;


import com.example.demo.entity.Products;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Products> getAllASC(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public List<Products> findAll() {
        return productRepository.findAll();
    }

    public List<Products> findByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public Products getProduct(int id) {
        return productRepository.findByIdAndStatus(id, "true");
    }

    public List<Products> findByStatusTrue() {
        return productRepository.findByStatusTrue();
    }

    ;

}
