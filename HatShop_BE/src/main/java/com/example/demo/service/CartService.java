package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public boolean save(Cart cart) {
        try {
            cartRepository.save(cart);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
