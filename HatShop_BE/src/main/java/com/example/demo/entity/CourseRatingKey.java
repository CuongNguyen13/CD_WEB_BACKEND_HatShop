package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CourseRatingKey implements Serializable {
    @Column(name = "product_id")
    int productId;

    @Column(name = "cart_id")
    int cartId;

    public CourseRatingKey() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseRatingKey that = (CourseRatingKey) o;
        return productId == that.productId &&
                cartId == that.cartId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, cartId);
    }
}
