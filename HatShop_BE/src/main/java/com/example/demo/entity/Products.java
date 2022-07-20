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

    @Column(name = "linkImage1")
    private String linkImage1;

    @Column(name = "linkImage2")
    private String linkImage2;

    @Column(name = "linkImage3")
    private String linkImage3;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "kind")
    private int kind;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkImage1() {
        return linkImage1;
    }

    public void setLinkImage1(String linkImage1) {
        this.linkImage1 = linkImage1;
    }

    public String getLinkImage2() {
        return linkImage2;
    }

    public void setLinkImage2(String linkImage2) {
        this.linkImage2 = linkImage2;
    }

    public String getLinkImage3() {
        return linkImage3;
    }

    public void setLinkImage3(String linkImage3) {
        this.linkImage3 = linkImage3;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

      public void add(){
        this.setQuantity(this.quantity+1);
    }
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
                ", user=" + user +

                '}';

    }

    public Products() {
    }
}
