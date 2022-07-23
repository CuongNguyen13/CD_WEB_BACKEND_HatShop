package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class SearchDTO {
    String name;
    Date biginDate;
    Date endate;
    double beginPrice;
    double endPrice;
    String kind;

    public SearchDTO(String name, Date biginDate, Date endate, double beginPrice, double endPrice, String kind) {
        this.name = name;
        this.biginDate = biginDate;
        this.endate = endate;
        this.beginPrice = beginPrice;
        this.endPrice = endPrice;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBiginDate() {
        return biginDate;
    }

    public void setBiginDate(Date biginDate) {
        this.biginDate = biginDate;
    }

    public Date getEndate() {
        return endate;
    }

    public void setEndate(Date endate) {
        this.endate = endate;
    }

    public double getBeginPrice() {
        return beginPrice;
    }

    public void setBeginPrice(double beginPrice) {
        this.beginPrice = beginPrice;
    }

    public double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(double endPrice) {
        this.endPrice = endPrice;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "name='" + name + '\'' +
                ", biginDate=" + biginDate +
                ", endate=" + endate +
                ", beginPrice=" + beginPrice +
                ", endPrice=" + endPrice +
                ", kind='" + kind + '\'' +
                '}';
    }
}
