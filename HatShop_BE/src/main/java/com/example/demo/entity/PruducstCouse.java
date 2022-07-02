package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pruducstCouse")
public class PruducstCouse {
    @EmbeddedId
    private CourseRatingKey id;
    @JsonIgnore
    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Products product;
    @JsonIgnore
    @ManyToOne
    @MapsId("cart_id")
    @JoinColumn(name = "cart_id")
    private Cart cart;


    public PruducstCouse() {
    }


}
