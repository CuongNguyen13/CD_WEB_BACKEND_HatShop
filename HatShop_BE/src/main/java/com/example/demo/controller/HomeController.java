package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value = {"/admin"}, method = RequestMethod.POST)
    public String admin() {
        return "Trang này là trang admin";
    }
}
