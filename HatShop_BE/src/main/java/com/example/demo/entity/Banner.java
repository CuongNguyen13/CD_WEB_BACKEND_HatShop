package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "linkImage")
    private String linkImage1;

    @Column(name = "linkImage2")
    private String linkImage2;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    public Banner() {
    }
}
