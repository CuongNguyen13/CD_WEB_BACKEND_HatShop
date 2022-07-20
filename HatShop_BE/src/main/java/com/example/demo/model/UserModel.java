package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

public class UserModel {
    @NotBlank
    private String email;
    @NotBlank
    private String pass;
    @NotBlank
    private String fistName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String province;
    @NotBlank
    private String address;
    private Date date;


    public UserModel() {

    }

    public UserModel(@NotBlank String email, @NotBlank String pass, @NotBlank String fistName, @NotBlank String lastName, @NotBlank String province, @NotBlank String address, Date date) {
        this.email = email;
        this.pass = pass;
        this.fistName = fistName;
        this.lastName = lastName;
        this.province = province;
        this.address = address;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", province='" + province + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
