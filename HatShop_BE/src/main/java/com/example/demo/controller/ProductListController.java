package com.example.demo.controller;

import com.example.demo.entity.Products;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProductListController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/sort")
    public ModelAndView sort(@RequestParam(name="field") String field) {
        ModelAndView mav = new ModelAndView("all");
        List<Products> getAllASC = productService.getAllASC(field);
        mav.addObject("all", getAllASC);
        return mav;
    }
}
