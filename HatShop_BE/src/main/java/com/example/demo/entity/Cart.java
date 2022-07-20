package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "totalPrice")
    private double totalPrice;


    @ManyToMany(mappedBy = "listCart")
    private Map<Integer, Products> data = new HashMap<>();


    public Cart() {
    }

    public Cart(User user, int quantity, double totalPrice, Map<Integer, Products> listProduct) {
        this.user = user;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.data = listProduct;
    }


    public void put(Products pro){
        if(pro==null) return;
        if(data.containsKey(pro.getId())){
            data.get(pro.getId()).add();//nếu sp tồn tại thì tăng lên
            return;
        }
        pro.setQuantity(1);//set số lượng là 1
        data.put(pro.getId(), pro);
    }
    public void update(String id, int quantity){
        if(quantity<0){
            return;
        }
        if(data.containsKey(id)){
            data.get(id).setQuantity(quantity);
        }
    }
    public void remove(String id){
        data.remove(id);
    }
    public long total(){
        long sum = 0;
        for(Products pro : data.values()){
            sum += pro.getPrice() + pro.getQuantity();
        }
        return  sum;
    }

    public static Cart getCart(Cart cart){
        return cart==null ? new Cart() : cart;
    }
    public void commit(HttpSession session){
        session.setAttribute("cart", this); //put ngược lại session
    }
}
