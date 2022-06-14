package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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


}
