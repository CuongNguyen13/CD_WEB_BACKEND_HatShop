package com.example.demo.dto;

import com.example.demo.entity.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartProductDTO {
    private int id;
    private int quantity;
    private Products products;
}
