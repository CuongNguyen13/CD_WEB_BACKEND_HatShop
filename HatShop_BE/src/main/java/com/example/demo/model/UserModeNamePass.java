package com.example.demo.model;

public class UserModeNamePass {
    private String email;
    private String pass;
    private String message;

    public UserModeNamePass() {
    }

    public UserModeNamePass(String message) {
        this.message = message;
    }

    public UserModeNamePass(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public UserModeNamePass(String email, String pass, String message) {
        this.email = email;
        this.pass = pass;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
