package com.example.demo.utilities;

import com.example.demo.entity.Role;
import com.example.demo.entity.RoleRatingKey;
import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ConvertUser {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    public User toEntity(UserModel model) {
        User user = new User();
        List<Role> roles = roleRepository.findByRoleName("USER");

        ArrayList<Role> listRole = new ArrayList<>();
        listRole.add(roles.get(0));
        user.setListRole(listRole);

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
