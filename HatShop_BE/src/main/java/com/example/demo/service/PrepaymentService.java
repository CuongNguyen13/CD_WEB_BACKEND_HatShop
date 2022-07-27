package com.example.demo.service;

import com.example.demo.dto.PrepaymentDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Prepayment;
import com.example.demo.entity.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.PrepaymentRespository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrepaymentService {
    @Autowired
    PrepaymentRespository prepaymentRespository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    public boolean savePayment(PrepaymentDTO prepaymentDTO){
        List<Cart> cartList = cartRepository.findByUserIdAndStatusTrue(prepaymentDTO.getUserId());
        User user = userRepository.findById(prepaymentDTO.getUserId());
        try {
            Prepayment prepayment = new Prepayment();
            prepayment.setCartList(cartList);
            prepayment.setUser(user);
            prepayment.setAddress(prepaymentDTO.getAddress());
            prepayment.setEmail(prepaymentDTO.getEmail());
            prepayment.setDescription(prepaymentDTO.getDescription());
            prepayment.setName(prepaymentDTO.getName());
            prepayment.setPhoneNumber(prepaymentDTO.getPhone());
            prepayment.setPrice(prepaymentDTO.getTotal());
            //date
            LocalDate myObj = LocalDate.now();
            prepayment.setDate(java.sql.Date.valueOf(myObj));
            prepayment.setStatus(true);

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
