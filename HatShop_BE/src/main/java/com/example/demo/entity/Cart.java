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

    @JoinColumn(name = "user_id")
    private int userId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "totalPrice")
    private double totalPrice;

    @Column (name = "product_id")
    private int productId;

    public Cart() {
    }
    @ManyToOne
    @JoinColumn(name = "prepayement_id")
    private Prepayment prepayment;
    @Column(name = "status")
    private boolean status;


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + userId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", productId=" + productId +
                '}';
    }
}
