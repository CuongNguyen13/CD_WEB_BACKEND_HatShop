package com.example.demo.service;


import com.example.demo.dto.ListPage;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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
//    public List<Products> findByStatusTrue(){
//        return productRepository.findByDateAndStatusTrue();
//    }
    public Products getProductDetail(int id){
        Products products=  productRepository.findById(id);
          ProductDTO dto = new ProductDTO();
          dto.setName(products.getName());
          dto.setDecription(products.getDescription());
          dto.setPrice(products.getPrice());
          dto.setKind(products.getKind());
          return products;
    }

    public Products finnById(int id){
        return productRepository.findById(id);
    }


    public List<Products> listProduct(){
        return productRepository.findAll();
    }

    public ListPage<Products> findAllByPage(int page, int limit){
        ListPage<Products> resp = new ListPage<>();
        Pageable paging = PageRequest.of(page - 1,limit);
        Page<Products> pageData = productRepository.findByStatusTrue(paging);

        resp.setList(pageData.getContent());
        resp.setCurrentPage(pageData.getNumber()+1);
        resp.setTotalItems((int)pageData.getTotalElements());
        resp.setTotalPages(pageData.getTotalPages());

        return resp;
    }


    public boolean updateStatusProduct(int id,boolean status) {
        try{
            Products products = productRepository.findById(id);
            products.setStatus(status);
            productRepository.save(products);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public boolean addProduct(Products products) {
        try {
            LocalDate myObj = LocalDate.now();
            products.setDate(java.sql.Date.valueOf(myObj));
            products.setStatus(true);
            productRepository.save(products);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public boolean checkNameProduct(@RequestParam String name){
        if (productRepository.findByName(name)!=null){
            return false;
        }else {
            return  true;
        }


    }

}
