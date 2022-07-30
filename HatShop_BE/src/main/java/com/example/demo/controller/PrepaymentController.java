package com.example.demo.controller;

import com.example.demo.dto.BillDTO;
import com.example.demo.dto.CartProductDTO;
import com.example.demo.dto.ListPage;
import com.example.demo.dto.PrepaymentDTO;
import com.example.demo.entity.Prepayment;
import com.example.demo.entity.Products;
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

    @GetMapping("/admin/prepayment")
    public ListPage<PrepaymentDTO> getListContact(@RequestParam(name = "limit",required = false,defaultValue = "5") int limit, @RequestParam(name = "page",required = false,defaultValue = "1") int page){
        return prepaymentService.findAllAdmin(page,limit);
    }

    @GetMapping("admin/order/status")
    public boolean updateStatus(@RequestParam int id, int status){
        return prepaymentService.updateStatus(id,status);
    }

}
