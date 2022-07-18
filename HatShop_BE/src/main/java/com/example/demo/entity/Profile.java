package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "avatarlink")
    private String avatarlink;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "workplace")
    private String workplace;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Profile() {
    }

    public Profile(String avatarlink, String name, int age, String workplace, String status, User user) {
        this.avatarlink = avatarlink;
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.status = status;
        this.user = user;
    }
}
