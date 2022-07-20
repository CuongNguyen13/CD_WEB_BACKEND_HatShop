package com.example.demo.controller;

import com.example.demo.entity.Products;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    ProductService productService;
    @RequestMapping(value = {"/admin"}, method = RequestMethod.POST)
    public String admin() {
        return "Trang này là trang admin";
    }

//    @RequestMapping(value = "/status")
//    public ModelAndView statusTrue() {
//        ModelAndView mav = new ModelAndView("search");
//        List<Products> listByName = productService.findByStatusTrue();
//        mav.addObject("listByName", listByName);
//        return mav;
//    }
}
