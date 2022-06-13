package com.example.demo.controller;
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
}
