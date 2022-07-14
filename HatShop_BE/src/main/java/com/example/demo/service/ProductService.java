package com.example.demo.service;


import com.example.demo.dto.ProductDTO;
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
        return productRepository.findByIdAndStatusTrue(id);
    }
    public List<Products> findByStatusTrue(){
        return productRepository.findByStatusTrue();
    }
    public ProductDTO getProductDetail(int id){
        Products products=  productRepository.findById(id);
          ProductDTO dto = new ProductDTO();
          dto.setName(products.getName());
          dto.setDecription(products.getDescription());
          dto.setPrice(products.getPrice());
          dto.setKind(products.getKind());
          return dto;
    }

}
