package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fistName")
    private String fistName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "province")
    private String province;

    @Column(name = "address")
    private String address;

    @Column(name = "code_recovery")
    private String codeRecovery;

    @Column(name = "time_recovery")
    private long timeRecovery;

    @Column(name = "enable")
    private boolean enable;

    @ManyToMany
    @JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> listRole;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Cart> listCart = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Contact> listContact = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Products> listProduct = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Prepayment> listPrepayment = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Bill> listBill = new ArrayList<>();



    public void setListBill(List<Bill> listBill) {
        this.listBill = listBill;
    }

    public User() {
    }
}
