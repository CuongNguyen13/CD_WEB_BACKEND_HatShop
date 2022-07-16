package com.example.demo.controller;

import com.example.demo.entity.Cart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {




    @PostMapping(value = "/addCart")
    public Cart addCart(@RequestBody Cart cart){

        return cart;
    }

}
