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
public class SearchContronller {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/search")
    public ModelAndView home(@RequestParam(name="field") String field) {
        ModelAndView mav = new ModelAndView("search");
        List<Products> listByName = productService.findByName(field);
        mav.addObject("listByName", listByName);
        return mav;
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
