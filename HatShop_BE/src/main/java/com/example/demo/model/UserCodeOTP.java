package com.example.demo.model;

public class UserCodeOTP {
    private String email;
    private String newPass;
    private String message;
    private int otp1;
    private int otp2;
    private int otp3;
    private int otp4;
    private int otp5;
    private int otp6;


    public UserCodeOTP(String email, String newPass, int otp1, int otp2, int otp3, int otp4, int otp5, int otp6) {
        this.email = email;
        this.newPass = newPass;
        this.otp1 = otp1;
        this.otp2 = otp2;
        this.otp3 = otp3;
        this.otp4 = otp4;
        this.otp5 = otp5;
        this.otp6 = otp6;
    }

    public UserCodeOTP(String email, String newPass, String message, int otp1, int otp2, int otp3, int otp4, int otp5, int otp6) {
        this.email = email;
        this.newPass = newPass;
        this.message = message;
        this.otp1 = otp1;
        this.otp2 = otp2;
        this.otp3 = otp3;
        this.otp4 = otp4;
        this.otp5 = otp5;
        this.otp6 = otp6;
    }

    public UserCodeOTP() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public int getOtp1() {
        return otp1;
    }

    public void setOtp1(int otp1) {
        this.otp1 = otp1;
    }

    public int getOtp2() {
        return otp2;
    }

    public void setOtp2(int otp2) {
        this.otp2 = otp2;
    }

    public int getOtp3() {
        return otp3;
    }

    public void setOtp3(int otp3) {
        this.otp3 = otp3;
    }

    public int getOtp4() {
        return otp4;
    }

    public void setOtp4(int otp4) {
        this.otp4 = otp4;
    }

    public int getOtp5() {
        return otp5;
    }

    public void setOtp5(int otp5) {
        this.otp5 = otp5;
    }

    public int getOtp6() {
        return otp6;
    }

    public void setOtp6(int otp6) {
        this.otp6 = otp6;
    }

    @Override
    public String toString() {
        return "UserCodeOTP{" +
                "email='" + email + '\'' +
                ", New Pass='" + newPass + '\'' +
                ", message='" + message + '\'' +
                otp1 + '\'' +
                otp2 + '\'' +
                otp3 + '\'' +
                otp4 + '\'' +
                otp5 + '\'' +
                otp6 + '\'' +
                '}';
    }
}
