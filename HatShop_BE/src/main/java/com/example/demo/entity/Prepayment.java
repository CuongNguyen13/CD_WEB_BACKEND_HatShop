package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "prepayments")
public class Prepayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private int status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "prepayment")
    private List<Cart> cartList;

    @Override
    public String toString() {
        return "Prepayment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", user=" + user +
                ", cartList=" + cartList +
                '}';
    }

    public Prepayment() {
    }

}
