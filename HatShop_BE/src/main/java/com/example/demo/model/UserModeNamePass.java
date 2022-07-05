package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class UserModeNamePass {
    @NotBlank
    private String email;
    @NotBlank
    private String pass;

    public UserModeNamePass() {
    }

    public UserModeNamePass(@NotBlank String email, @NotBlank String pass) {
        this.email = email;
        this.pass = pass;
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

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
