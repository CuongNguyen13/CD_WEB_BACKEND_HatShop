package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class PrepaymentDTO {
    private int userId;
    private String name;
    private String phone;
    private String address;
    private String description;
    private double total;
    private String email;
    private Date date;
    private int status;
}
