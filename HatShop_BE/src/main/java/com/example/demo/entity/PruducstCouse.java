package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "pruducstCouse")
public class PruducstCouse {
    @EmbeddedId
    private CourseRatingKey id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Products product;

    @ManyToOne
    @MapsId("cart_id")
    @JoinColumn(name = "cart_id")
    private Cart cart;


    public PruducstCouse() {
    }

    public CourseRatingKey getId() {
        return id;
    }

    public void setId(CourseRatingKey id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
