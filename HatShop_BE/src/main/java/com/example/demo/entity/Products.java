package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

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
}
