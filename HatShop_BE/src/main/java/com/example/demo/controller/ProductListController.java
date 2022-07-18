package com.example.demo.controller;

import com.example.demo.dto.ListPage;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Contact;
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

    @GetMapping("/admin/listProduct")
    public List<Products> listProduct(){
        return productService.listProduct();
    }


//    @GetMapping(value = "/detailProduct/{id}")
//    public Products detailProduct(@PathVariable(name="id") int id) {
//        return productService.getProduct(id);
//    }

    @GetMapping(value = "/detailProduct/{id}")
    public Products detailProduct(@PathVariable(name="id") int id) {
        return productService.getProductDetail(id);
    }

    @GetMapping("/admin/product")
    public ListPage<Products> getListContact(@RequestParam(name = "limit",required = false,defaultValue = "5") int limit, @RequestParam(name = "page",required = false,defaultValue = "1") int page){
        return productService.findAllByPage(page,limit);
    }

    @PostMapping("/admin/product/delete")
    public boolean deleteProduct(@RequestBody int id){
        return productService.updateStatusProduct(id,false);
    }


}
