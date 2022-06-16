package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private int quantity;
    private Date date;
    private boolean status;
    private double price;
    private String decription;
    private String linkImage;
    private  int kind;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", status=" + status +
                ", price=" + price +
                ", decription='" + decription + '\'' +
                ", linkImage='" + linkImage + '\'' +
                ", kind=" + kind +
                '}';
    }
}
