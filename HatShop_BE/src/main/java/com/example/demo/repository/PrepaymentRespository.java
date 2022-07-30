package com.example.demo.repository;

import com.example.demo.entity.Prepayment;
import com.example.demo.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrepaymentRespository extends JpaRepository<Prepayment,Integer> {

    Prepayment findById(int id);

    Page<Prepayment> findAll(Pageable paging);

    List<Prepayment> findAll();



}
