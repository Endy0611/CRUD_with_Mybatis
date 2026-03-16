package com.example.batis_demo.service;

import com.example.batis_demo.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks(int size, int page);
}
