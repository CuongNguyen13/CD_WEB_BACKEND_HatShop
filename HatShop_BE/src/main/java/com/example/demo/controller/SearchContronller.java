package com.example.demo.controller;

import com.example.demo.entity.Products;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class SearchContronller {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/searchNoFilter")
    public  List<Products> searchNoFilter(@RequestParam(name="name") String name) {
        return productService.findByNameContainingIgnoreCaseAndStatusTrue(name);
    }

//    @RequestMapping(value = "/index")
//    public ModelAndView home() {
//        ModelAndView mav = new ModelAndView("index");
//        return mav;
//    }
//
//    @RequestMapping(value = "/status")
//    public List<Products> status() {
//        List<Products> listByName = productService.findByStatusTrue();
//        return listByName;
//    }
}
