package com.example.demo.controller;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.model.ProfileDTO;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utilities.UpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/Profile")
    public ProfileDTO profile(@RequestBody Integer id) {
        User user = userService.findById(id);
        System.out.println("User = " + user);
        Profile profile = profileRepository.findByUser(user);
        System.out.println("Profile = " + profileRepository.findByUser(user));
        ProfileDTO profileDTO = new ProfileDTO(profile.getAvatarlink(), user.getEmail(), user.getFistName(), user.getLastName(),
                user.getProvince(), user.getAddress(), profile.getAge(), profile.getWorkplace(), user.getDateOfBirth());
        System.out.println("profileDTO = " + profileDTO);
        return profileDTO;
    }

    @PostMapping("/UpdateProfile")
    public String updateProfile(@Validated @RequestBody ProfileDTO profileDTO, BindingResult result) {
        if (!result.hasErrors()) {
            User user = userService.findByEmail(profileDTO.getEmail());
            Profile profile = profileRepository.findByUser(user);
            UpdateDTO updateDTO = new UpdateDTO();
            System.out.println("User = " + user);
            System.out.println("Profile = " + profile);
            System.out.println("profileDTO = " + profileDTO);
            updateDTO.SetUser(user, profileDTO);
            userRepository.save(user);
            updateDTO.SetProfile(profile, profileDTO);
            profileRepository.save(profile);
            System.out.println("result : " + result.hasErrors());
            return "lưu thành công";
        } else {
            return "Lưu thất bại";
        }
    }

}