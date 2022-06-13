package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
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

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<UserRole> listUserRole = new ArrayList<>();

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<UserRole> getUserRole() {
        return listUserRole;
    }

    public void setUserRole(List<UserRole> listUserRole) {
        this.listUserRole = listUserRole;
    }

    public List<Products> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Products> listProduct) {
        this.listProduct = listProduct;
    }

    public String getCodeRecovery() {
        return codeRecovery;
    }

    public void setCodeRecovery(String codeRecovery) {
        this.codeRecovery = codeRecovery;
    }

    public long getTimeRecovery() {
        return timeRecovery;
    }

    public void setTimeRecovery(long timeRecovery) {
        this.timeRecovery = timeRecovery;
    }

    public User() {
    }
}
