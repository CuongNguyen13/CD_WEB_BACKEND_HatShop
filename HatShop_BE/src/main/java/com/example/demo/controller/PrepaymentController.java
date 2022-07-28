package com.example.demo.controller;

import com.example.demo.dto.PrepaymentDTO;
import com.example.demo.service.PrepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrepaymentController {
    @Autowired
    PrepaymentService prepaymentService;

    @PostMapping("/prepayment/save")
    public boolean save(@RequestBody PrepaymentDTO prepaymentDTO){
        return  prepaymentService.savePayment(prepaymentDTO);
    }



}
