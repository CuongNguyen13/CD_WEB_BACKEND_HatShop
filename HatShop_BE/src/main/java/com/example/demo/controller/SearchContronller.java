package com.example.demo.controller;

import com.example.demo.dto.SearchDTO;
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

    @GetMapping(value = "/searchNoFilter")
    public  List<Products> searchNoFilter(@RequestParam String name) {
        System.err.println(name);
        if (name.trim().length() == 0)
            return null;
        return productService.findByNameContainingIgnoreCaseAndStatusTrue(name);
    }

    @GetMapping(value = "/search")
    public List<Products> search(@RequestBody SearchDTO searchDTO) {
        System.err.println(searchDTO);
        System.out.println("searchDTO = " + productService.findByAllFill(searchDTO.getName(), searchDTO.getBiginDate(), searchDTO.getEndate(), searchDTO.getBeginPrice(), searchDTO.getEndPrice(), searchDTO.getKind()));
        return productService.findByAllFill(searchDTO.getName(), searchDTO.getBiginDate(), searchDTO.getEndate(), searchDTO.getBeginPrice(), searchDTO.getEndPrice(), searchDTO.getKind());
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
