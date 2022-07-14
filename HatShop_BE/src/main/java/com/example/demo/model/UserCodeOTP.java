package com.example.demo.model;

public class UserCodeOTP {
    private String email;
    private String pass;
    private String message;
    private String otp;

    public UserCodeOTP(String email, String pass, String message, String otp) {
        this.email = email;
        this.pass = pass;
        this.message = message;
        this.otp = otp;
    }

    public UserCodeOTP(String email, String pass, String otp) {
        this.email = email;
        this.pass = pass;
        this.otp = otp;
    }

    public UserCodeOTP() {
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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "UserCodeOTP{" +
                "email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", message='" + message + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
