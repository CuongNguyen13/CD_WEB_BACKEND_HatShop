package com.example.demo.controller;

import com.example.demo.entity.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Validate {
    @GetMapping(value = "/validateRegister")
    public String home() {
        return "";
    }
}
