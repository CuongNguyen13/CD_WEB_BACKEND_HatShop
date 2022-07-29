package com.example.demo.service;

import com.example.demo.dto.BillDTO;
import com.example.demo.dto.CartProductDTO;
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

    @Autowired
    CartService cartService;

    public String savePayment(PrepaymentDTO prepaymentDTO){
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

           Prepayment pre = prepaymentRespository.save(prepayment);
            for (int i = 0; i < cartList.size(); i++) {
                cartList.get(i).setStatus(false);
                cartList.get(i).setPrepayment(prepayment);
                cartRepository.save(cartList.get(i));
            }
            return  pre.getId()+"";
        }catch (Exception e){



            return null;
        }
    }


    public BillDTO billDTO(int id){
        List<CartProductDTO> cartProductDTOList = cartService.listCartPayment(id);
        Prepayment prepayment = prepaymentRespository.findById(id);
        BillDTO billDTO = new BillDTO();
        billDTO.setCart(cartProductDTOList);
        billDTO.setAddress(prepayment.getAddress());
        billDTO.setDate(prepayment.getDate());
        billDTO.setDescription(prepayment.getDescription());
        billDTO.setEmail(prepayment.getEmail());
        billDTO.setName(prepayment.getName());
        billDTO.setPhone(prepayment.getPhoneNumber());
        billDTO.setId(prepayment.getId());
        billDTO.setTotal(prepayment.getPrice());
        billDTO.setStatus(prepayment.isStatus());
        return billDTO;
    }
}
