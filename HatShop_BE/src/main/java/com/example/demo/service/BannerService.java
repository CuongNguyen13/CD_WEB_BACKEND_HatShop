package com.example.demo.service;

import com.example.demo.entity.Banner;
import com.example.demo.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerRepository bannerRepository;
    //find banner have status = true
    public List<Banner> findBannerTrue(){
        return  bannerRepository.findAll();
    }

}
