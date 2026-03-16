package com.example.batis_demo.service;

import com.example.batis_demo.model.entity.Author;
import com.example.batis_demo.model.request.AuthorRequest;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    List<Author> getAllAuthor(int size, int page);

    Author getAuthorById(Long authorId);

    Author saveAuthor(AuthorRequest authorRequest);

    Author deleteAuthorById(Long authorId);
}
