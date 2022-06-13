package com.example.demo.model;

import javax.validation.constraints.NotBlank;

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
    @NotBlank
    private String day;
    @NotBlank
    private String month;
    @NotBlank
    private String year;


    public UserModel() {

    }

    public UserModel(@NotBlank String email, @NotBlank String pass, @NotBlank String fistName, @NotBlank String lastName, @NotBlank String province, @NotBlank String address, @NotBlank String day, @NotBlank String month, @NotBlank String year) {
        this.email = email;
        this.pass = pass;
        this.fistName = fistName;
        this.lastName = lastName;
        this.province = province;
        this.address = address;
        this.day = day;
        this.month = month;
        this.year = year;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
