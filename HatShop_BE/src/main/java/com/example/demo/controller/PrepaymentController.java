package com.example.demo.controller;

import com.example.demo.dto.BillDTO;
import com.example.demo.dto.CartProductDTO;
import com.example.demo.dto.PrepaymentDTO;
import com.example.demo.service.CartService;
import com.example.demo.service.PrepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrepaymentController {
    @Autowired
    PrepaymentService prepaymentService;



    @PostMapping("/prepayment/save")
    public String save(@RequestBody PrepaymentDTO prepaymentDTO){
        return  prepaymentService.savePayment(prepaymentDTO);
    }

    @GetMapping("bill")
    public BillDTO listCart(@RequestParam int id){
        return prepaymentService.billDTO(id);
    }


}
