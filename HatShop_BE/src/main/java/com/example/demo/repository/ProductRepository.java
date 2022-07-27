package com.example.demo.repository;

import com.example.demo.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findAll(Sort sort);
    List<Products> findByNameContainingIgnoreCaseAndStatusTrue(String nameSong);
    Products findByIdAndStatusTrue(int id);
    Products findById(int id);
    List<Products> findByStatusTrue();

    Page<Products> findByStatusTrue(Pageable paging);

    List<Products> findByName(String name);

    List<Products> findByDateBetween(Date startDate, Date endDate);

    List<Products> findByPriceBetween(double biginPrice, double endPrice);

    List<Products> findByNameContainingIgnoreCaseAndStatusTrueAndDateBetweenAndPriceBetweenAndKind(String name, Date startDate, Date endDate, double biginPrice, double endPrice, String kind);
    Page<Products> findByKindAndStatusTrue(String kind,Pageable paging);

}
