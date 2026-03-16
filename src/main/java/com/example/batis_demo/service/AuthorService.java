package com.example.batis_demo.service;

import com.example.batis_demo.model.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor(int size, int page);
}
