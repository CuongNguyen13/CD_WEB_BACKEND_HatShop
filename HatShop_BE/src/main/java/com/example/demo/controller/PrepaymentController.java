package com.example.demo.controller;

import com.example.demo.service.PrepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrepaymentController {
    @Autowired
    PrepaymentService prepaymentService;

    @GetMapping("/prepayment/save")
    public boolean save(@RequestParam int id){
        return  prepaymentService.savePayment(id);
    }




}
