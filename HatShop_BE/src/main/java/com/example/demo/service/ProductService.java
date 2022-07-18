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
    public List<Products> findByStatusTrue(){
        return productRepository.findByStatusTrue();
    }
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


    public boolean addProduct(ProductDTO productDTO) {
        try {
            Products products = new Products();
            LocalDate myObj = LocalDate.now();
            products.setDate(java.sql.Date.valueOf(myObj));
            products.setStatus(true);
            products.setKind(products.getKind());
            products.setLinkImage1(products.getLinkImage1());
            products.setLinkImage2(products.getLinkImage2());
            products.setLinkImage3(products.getLinkImage3());
            products.setPrice(productDTO.getPrice());
            products.setDescription(productDTO.getDecription());
            User user = new User();
            user.setId(productDTO.getUserId());
            products.setUser(user);
            products.setQuantity(productDTO.getQuantity());
            productRepository.save(products);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
