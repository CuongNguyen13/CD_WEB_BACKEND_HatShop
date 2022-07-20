package com.example.demo.model;


import java.sql.Date;

public class ProfileDTO {
    String avatarlink;
    String email;
    String fistName;
    String lastName;
    String province;
    String address;
    int age;
    String workplace;
    Date dateOfBirth;


    public ProfileDTO(String avatarlink, String email, String fistName, String lastName, String province, String address, int age, String workplace, Date dateOfBirth) {
        this.avatarlink = avatarlink;
        this.email = email;
        this.fistName = fistName;
        this.lastName = lastName;
        this.province = province;
        this.address = address;
        this.age = age;
        this.workplace = workplace;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public ProfileDTO() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAvatarlink() {
        return avatarlink;
    }

    public void setAvatarlink(String avatarlink) {
        this.avatarlink = avatarlink;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "avatarlink='" + avatarlink + '\'' +
                ", email='" + email + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", province='" + province + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
