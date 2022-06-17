package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private boolean status;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "linkImage")
    private String linkImage;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "kind")
    private int kind;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "pruducstCouse", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private List<Cart> listCart;


    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", status=" + status +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", linkImage='" + linkImage + '\'' +
                ", user=" + user +
                ", listCart=" + listCart +
                '}';

    }

    public Products() {
    }
}
