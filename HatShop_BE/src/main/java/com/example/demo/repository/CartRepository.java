package com.example.demo.repository;

import com.example.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findByProductIdAndUserIdAndStatusTrue(int productId,int userId);

    List<Cart> findByUserIdAndStatusTrue(int userId);

    Cart findById(int id);

    List<Cart> findByPrepaymentId(int prepayment);



}
