package com.example.demo.controller;

import com.example.demo.dto.CartDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductResponseModel;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.model.CartModel;
import com.example.demo.model.UserModeNamePass;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @GetMapping("/cart/check")
    public boolean checkExit(@RequestParam int idProduct, int idUser){
        return cartService.checkExit(idProduct,idUser);
    }
    @PostMapping("cart/add")
    public boolean addCart(@RequestBody CartDTO cartDTO){
        System.err.println(cartDTO);
        return cartService.save(cartDTO);
    }

}
