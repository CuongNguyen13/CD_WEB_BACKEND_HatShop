package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "linkImage")
    private String linkImage;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    public Banner() {
    }
}
