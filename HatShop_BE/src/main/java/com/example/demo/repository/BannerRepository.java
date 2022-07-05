package com.example.demo.repository;

import com.example.demo.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Integer> {

    List<Banner> findAll();

}
