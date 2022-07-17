package com.example.demo.repository;

import com.example.demo.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    List<Contact> findByStatus(int status,Sort sort);

    Contact findById(int id);

    Page<Contact> findByStatusTrue(Pageable paging);

}
