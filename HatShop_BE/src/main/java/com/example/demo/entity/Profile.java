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

    public String getAvatarlink() {
        return avatarlink;
    }

    public void setAvatarlink(String avatarlink) {
        this.avatarlink = avatarlink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
