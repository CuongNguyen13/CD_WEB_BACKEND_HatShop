package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping(value = "/addCart")
    public Cart addCart(@RequestBody CartModel model, HttpSession session) {
        Products product = productService.finnById(model.getIdProduct());
        User user = userService.findById(model.getIdUser());

        if (user != null) {
            Cart c = new Cart();
            c.put(product);
            return c;
        } else {
            return new Cart();
        }
    }

}
