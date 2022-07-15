package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.UserModeNamePass;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.utilities.ConvertUser;
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
    @PostMapping("/login1")
    public User login1(@RequestBody UserModeNamePass user) {
        if (!userService.login1(user.getEmail(), user.getPass())) {
            return new User();
        }
        return userService.findByEmail(user.getEmail());
    }

    //trả vể user cho lưu sessionStorage bên front
//    @GetMapping("/login")
//    public User(){
//        return new user;
//    }

    @RequestMapping(value = {"/"})
    public ModelAndView loginPage(ModelMap model) {
        return new ModelAndView("login", model);
    }

}
