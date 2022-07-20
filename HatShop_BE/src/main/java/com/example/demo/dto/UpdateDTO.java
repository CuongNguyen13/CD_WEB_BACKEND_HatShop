package com.example.demo.dto;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.dto.ProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class UpdateDTO {
    public User SetUser(User user, ProfileDTO profileDTO) {
        user.setFistName(profileDTO.getFistName());
        user.setLastName(profileDTO.getLastName());
        user.setAddress(profileDTO.getAddress());
        user.setProvince(profileDTO.getProvince());
        user.setDateOfBirth(profileDTO.getDateOfBirth());
        return user;
    }
    public Profile SetProfile(Profile profile, ProfileDTO profileDTO) {
        profile.setAge(profileDTO.getAge());
        profile.setAvatarlink(profileDTO.getAvatarlink());
        profile.setName(profileDTO.getLastName() + profileDTO.getLastName());
        return profile;
    }
}
