package com.example.demo.service;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    public boolean save(CartDTO cartDTO) {

        if (!checkExit(cartDTO.getProductId(),cartDTO.getProductId())){
            Cart cart = new Cart();
            cart.setQuantity(cartDTO.getQuantity());
            System.out.println(cartDTO.getUserId());
            User user = userRepository.findById(cartDTO.getUserId());
            System.err.println(user.toString());
            cart.setUser(user);
            cart.setProductId(cartDTO.getProductId());
           try {
               cartRepository.save(cart);
               return true;
           }catch (Exception e){
               return  false;
           }

        }else {
            return  false;
        }

    }

    public boolean checkExit(int idProduct,int idUser){
        if (cartRepository.findByProductIdAndUserId(idProduct,idUser)!=null){
            return true;
        }else return false;

    }


}
