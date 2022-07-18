package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
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

    @Column(name = "Role")
    private boolean role;

<<<<<<< HEAD
=======
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> listRole;
>>>>>>> 6666e14a43598dbf3e2e26ba24b66aebd0a0f1d1

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Cart> getListCart() {
        return listCart;
    }

    public void setListCart(List<Cart> listCart) {
        this.listCart = listCart;
    }

    public List<Products> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Products> listProduct) {
        this.listProduct = listProduct;
    }

    public List<Prepayment> getListPrepayment() {
        return listPrepayment;
    }

    public void setListPrepayment(List<Prepayment> listPrepayment) {
        this.listPrepayment = listPrepayment;
    }

    public List<Bill> getListBill() {
        return listBill;
    }

    public void setListBill(List<Bill> listBill) {
        this.listBill = listBill;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Cart> listCart = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Products> listProduct = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Prepayment> listPrepayment = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Bill> listBill = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", province='" + province + '\'' +
                ", address='" + address + '\'' +
                ", codeRecovery='" + codeRecovery + '\'' +
                ", timeRecovery=" + timeRecovery +
                ", enable=" + enable +
                ", role=" + role +
                ", listCart=" + listCart +
                ", listProduct=" + listProduct +
                ", listPrepayment=" + listPrepayment +
                ", listBill=" + listBill +
                '}';
    }
}
