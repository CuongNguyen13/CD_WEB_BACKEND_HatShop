package com.example.demo.model;

public class CartModel {
    int idProduct;
    int idUser;

    public CartModel(int idProduct, int idUser) {
        this.idProduct = idProduct;
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
