package com.example.demo.repository;

import com.example.demo.entity.Products;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findAll(Sort sort);
    List<Products> findByNameContainingIgnoreCase(String nameSong);
    Products findProductsById(int id);
}
