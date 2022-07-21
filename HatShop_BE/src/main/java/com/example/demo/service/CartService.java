package com.example.demo.service;

import com.example.demo.dto.CartDTO;
import com.example.demo.dto.CartProductDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;
    public boolean save(CartDTO cartDTO) {
        boolean check = checkExit(cartDTO.getProductId(),cartDTO.getUserId());
        System.out.println(check);
        if (check==false){
            Cart cart = new Cart();
            cart.setQuantity(cartDTO.getQuantity());
//            System.out.println(cartDTO.getUserId());
//            User user = userRepository.findById(cartDTO.getUserId());
            cart.setUserId(cartDTO.getUserId());
            cart.setProductId(cartDTO.getProductId());
           try {
               cartRepository.save(cart);
               return true;
           }catch (Exception e){
               return  false;
           }

        }else {
            try {
                Cart cart = cartRepository.findByProductIdAndUserId(cartDTO.getProductId(), cartDTO.getUserId());
                int quantity = cart.getQuantity() + cartDTO.getQuantity();
                cart.setQuantity(quantity);
                cartRepository.save(cart);
                return  true;
            } catch (Exception exception) {
                return false;
            }

        }
    }

    public boolean checkExit(int idProduct,int idUser){
        if (cartRepository.findByProductIdAndUserId(idProduct,idUser)!=null){
            return true;
        }else return false;

    }

    public List<CartProductDTO> listCart(int id){
        List<Cart> cartList =  cartRepository.findByUserId(id);
        List<CartProductDTO> cartProductDTOS = new ArrayList<>();

        for (int i = 0; i <cartList.size(); i++) {
            Products products = productRepository.findById(cartList.get(i).getProductId());
            CartProductDTO cartProductDTO = new CartProductDTO();
            cartProductDTO.setProducts(products);
            cartProductDTO.setId(cartList.get(i).getId());
            cartProductDTO.setQuantity(cartList.get(i).getQuantity());
            cartProductDTOS.add(cartProductDTO);
        }
        return cartProductDTOS;
    }
    public boolean deleteItemCart(int id){
        try {
            cartRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
