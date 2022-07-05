package com.example.demo.controller;

import com.example.demo.entity.Banner;
import com.example.demo.service.BannerService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {
    @Autowired
    BannerService bannerService;

    @GetMapping(value = "/banner")
    public List<Banner> banner(){
        return bannerService.findBannerTrue();
    }
}
