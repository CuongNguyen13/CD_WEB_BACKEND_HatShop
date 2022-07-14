package com.example.demo.model;

import java.util.ArrayList;

public class RegisterModel {
    ArrayList<Integer> dayList;
    ArrayList<Integer> monthList;
    ArrayList<Integer> yearList;
    String message;

    public RegisterModel() {
    }

    public RegisterModel(String message) {
        this.message = message;
    }

    public RegisterModel(ArrayList<Integer> dayList, ArrayList<Integer> monthList, ArrayList<Integer> yearList, String message) {
        this.dayList = dayList;
        this.monthList = monthList;
        this.yearList = yearList;
        this.message = message;
    }

    public ArrayList<Integer> getDayList() {
        return dayList;
    }

    public void setDayList(ArrayList<Integer> dayList) {
        this.dayList = dayList;
    }

    public ArrayList<Integer> getMonthList() {
        return monthList;
    }

    public void setMonthList(ArrayList<Integer> monthList) {
        this.monthList = monthList;
    }

    public ArrayList<Integer> getYearList() {
        return yearList;
    }

    public void setYearList(ArrayList<Integer> yearList) {
        this.yearList = yearList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DayModel{" +
                "dayList=" + dayList +
                ", monthList=" + monthList +
                ", yearList=" + yearList +
                ", message=" + message +
                '}';
    }
}
