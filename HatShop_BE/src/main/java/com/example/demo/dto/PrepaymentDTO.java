package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PrepaymentDTO {
    private int userId;
    private String name;
    private String phone;
    private String address;
    private String description;
    private int total;
    private String email;
}
