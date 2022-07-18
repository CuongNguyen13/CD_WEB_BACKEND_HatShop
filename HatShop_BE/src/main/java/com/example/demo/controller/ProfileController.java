package com.example.demo.controller;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    UserService userService;

    @PostMapping("/Profile")
    public Profile profile(@RequestParam(name = "id") int id) {
        User user = userService.findById(id);
        System.out.println("User = " + user);
        System.out.println("Profile = " + profileRepository.findByUser(user));
        return profileRepository.findByUser(user);
    }

}