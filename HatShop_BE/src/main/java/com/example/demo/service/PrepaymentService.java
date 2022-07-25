package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Prepayment;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.PrepaymentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrepaymentService {
    @Autowired
    PrepaymentRespository prepaymentRespository;
    @Autowired
    CartRepository cartRepository;


    public boolean savePayment(int idUser){
        List<Cart> cartList = cartRepository.findByUserId(idUser);
        try {
            Prepayment prepayment = new Prepayment();
            prepayment.setCartList(cartList);
            prepaymentRespository.save(prepayment);

            return  true;
        }catch (Exception e){



            return false;
        }
    }
}
