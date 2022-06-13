package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(ModelMap model
            , @RequestParam(value = "email", required = false) String email,
                              @RequestParam(value = "password", required = false) String password,
                              HttpSession session) {

        if (!userService.login(email, password)) {
            model.addAttribute("login", false);
            return new ModelAndView("login", model);
        }
        session.setAttribute("user", userService.findByEmail(email));
        return new ModelAndView("redirect:/forgetpass", model);
    }

    @RequestMapping(value = {"" , "/login"} , method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model){
        return new ModelAndView("login" , model);
    }

}
