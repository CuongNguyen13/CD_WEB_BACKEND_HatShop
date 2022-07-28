package com.example.demo.controller;

import com.example.demo.dto.CartDTO;
import com.example.demo.dto.CartProductDTO;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//        System.err.println(cartDTO.toString());
        return cartService.save(cartDTO);
    }


    @GetMapping("cart/list")
    public List<CartProductDTO> listCart(@RequestParam int id){
        System.out.println("id:"+id);
        return cartService.listCart(id);
    }

    @GetMapping("cart/delete")
    public boolean deleteCart(@RequestParam int id){
        return cartService.deleteItemCart(id);
    }
    
    @GetMapping("cart/checkEmpty")
    public boolean checkEmpty(@RequestParam int id){
        return cartService.checkEmpty(id);
    }

}
