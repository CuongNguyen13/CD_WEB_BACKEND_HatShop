package com.example.demo.controller;

import com.example.demo.entity.Products;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class SearchContronller {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/search")
    public  List<Products> home(@RequestParam(name="field") String field) {
        return productService.findByName(field);
    }
    @RequestMapping(value = "/index")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping(value = "/status")
    public List<Products> status() {
        List<Products> listByName = productService.findByStatusTrue();
        return listByName;
    }
}
