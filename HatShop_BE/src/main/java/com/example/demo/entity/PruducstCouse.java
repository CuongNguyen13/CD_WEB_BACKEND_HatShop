package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "PruducstCouse")
public class PruducstCouse {

    @EmbeddedId
    private CourseRatingKey id;

    @ManyToOne
    @MapsId("products_id")
    @JoinColumn(name = "products_id")
    private Products products;

    @ManyToOne
    @MapsId("cart_id")
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
