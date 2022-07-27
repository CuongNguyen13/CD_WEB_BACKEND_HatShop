package com.example.demo.controller;

import com.example.demo.dto.ListPage;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Products;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/admin/user")
    public ListPage<UserDTO> getListContact(@RequestParam(name = "limit",required = false,defaultValue = "5") int limit, @RequestParam(name = "page",required = false,defaultValue = "1") int page){
        return userService.findAll(page,limit);
    }

    @PostMapping("/admin/block")
    public boolean blockUser(@RequestBody int id){
        return userService.blockUser(id);
    }

    @GetMapping("/user/payment")
    public  UserDTO userPayment(@RequestParam int id){
        return  userService.userPayment(id);
    }

}
