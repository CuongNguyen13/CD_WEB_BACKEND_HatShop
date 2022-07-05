package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
        User user = (User) session.getAttribute("user");
        System.out.println("user : " + user.getListRole());

        User u = userService.findByEmail(email);
        System.out.println("user : " + u.getListRole());
        return new ModelAndView("redirect:/forgetpass", model);
    }



//    @PostMapping(value = "/login1")
//    public String login1(@RequestParam User user) String password,
//                              HttpSession session) {
//
//        if (!userService.login(email, password)) {
//
//            return "fail";
//        }
////        session.setAttribute("user", userService.findByEmail(email));
////        User user = (User) session.getAttribute("user");
////
////
////        System.out.println("user : " + user.getListRole());
//        if (admin= true) return "successAdmin";
//        User u = userService.findByEmail(email);
//        System.out.println("user : " + u.getListRole());
//
//        return "success";
//    }


    @RequestMapping(value = {"/" , "/login"} , method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model){
        return new ModelAndView("login" , model);
    }

}
