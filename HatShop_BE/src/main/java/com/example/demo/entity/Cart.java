package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "userName")
    private String userName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private double price;

    @Column(name = "dateBuy")
    private Date dateBuy;

    @Column(name = "linkImage")
    private String linkImage;

    @Column(name = "totalPrice")
    private double totalPrice;

    @ManyToMany(mappedBy = "listCart")
    private List<Products> listProduct = new ArrayList<>();

    public Cart() {
    }


}
