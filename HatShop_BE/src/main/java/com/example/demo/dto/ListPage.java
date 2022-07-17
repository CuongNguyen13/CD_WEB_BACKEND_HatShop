package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ListPage<T> {
    private int totalPages;
    private int totalItems;
    private int currentPage;
    private List<T> list;
}
