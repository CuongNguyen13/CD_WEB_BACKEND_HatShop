package com.example.demo.controller;
import com.example.demo.model.RegisterModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.utilities.CreateDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class RegisterController {
    @Autowired
    CreateDate createDate ;
    @Autowired
    UserService userService ;

    @RequestMapping(value = "/register")
    public ModelAndView register(@Valid @ModelAttribute(name = "user") UserModel user, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("listDay", createDate.createDays());
            model.addAttribute("listMonth" , createDate.createMonths());
            model.addAttribute("listYear", createDate.createYears());
            return new ModelAndView("register", model) ;
        }
        else {
            if(userService.saveUser(user)){
                model.addAttribute("register" ,true);
                return new ModelAndView("redirect:/login" , model) ;
            }
        }
        model.addAttribute("internal", true);
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/register2")
    public RegisterModel register2(@Valid @RequestBody UserModel user, BindingResult result){
        RegisterModel dateModel = new RegisterModel(createDate.createDays(), createDate.createMonths(), createDate.createYears(), "Register failed");
        if(result.hasErrors()){
            System.out.println("No1");
            return dateModel ;
        }
        else {
            if(userService.saveUser(user)){
                System.out.println("Success = " + user);
                return new RegisterModel("Register success") ;
            }
        }
        System.out.println("No2");
        return dateModel;
    }
}

//{
//        "email":"hapham@gmail.com",
//        "pass":"123",
//        "fistName":"Pham",
//        "lastName":"Ha",
//        "province":"HCM",
//        "address":"BIEN HOA",
//        "day":"12",
//        "month":"2",
//        "year":"2009"
//        }
