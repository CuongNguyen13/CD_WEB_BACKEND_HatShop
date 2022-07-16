package com.example.demo.dto;

import java.io.Serializable;

public class ProductResponseModel implements Serializable {
    private String name;
    private int quantity;
    private double price;
    private String linkImage;

    public ProductResponseModel(String name, int quantity, double price, String linkImage) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.linkImage = linkImage;
    }

    public ProductResponseModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }
}
