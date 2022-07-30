package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BillDTO {
    private int id;
    private String name;
    private String email;
    private String description;
    private double total;
    private String phone;
    private Date date;
    private String address;
    private List<CartProductDTO> cart;
    private int status;
}
