package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Prepayment;
import com.example.demo.entity.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.PrepaymentRespository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrepaymentService {
    @Autowired
    PrepaymentRespository prepaymentRespository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    public boolean savePayment(int idUser){
        List<Cart> cartList = cartRepository.findByUserIdAndStatusTrue(idUser);
        User user = userRepository.findById(idUser);
        try {
            Prepayment prepayment = new Prepayment();
            prepayment.setCartList(cartList);
            prepayment.setUser(user);
            prepaymentRespository.save(prepayment);
            for (int i = 0; i < cartList.size(); i++) {
                cartList.get(i).setStatus(false);
                cartList.get(i).setPrepayment(prepayment);
                cartRepository.save(cartList.get(i));
            }
            return  true;
        }catch (Exception e){



            return false;
        }
    }
}
