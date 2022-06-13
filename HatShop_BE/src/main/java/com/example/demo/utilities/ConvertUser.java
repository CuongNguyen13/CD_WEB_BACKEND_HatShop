package com.example.demo.utilities;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConvertUser {
    public User toEntity(UserModel model) {
        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(model.getPass());
        user.setFistName(model.getFistName());
        user.setLastName(model.getLastName());
        user.setProvince(model.getProvince());
        user.setAddress(model.getAddress());
        user.setDateOfBirth(formatDate(model));

        return user;

    }

    private Date formatDate(UserModel model) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = model.getDay() + "/" + model.getMonth() + "/" + model.getYear();
        Date date = null;
        try {
            date = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
