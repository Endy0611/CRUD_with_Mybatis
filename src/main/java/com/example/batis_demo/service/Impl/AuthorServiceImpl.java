package com.example.batis_demo.service.Impl;

import com.example.batis_demo.model.entity.Author;
import com.example.batis_demo.repository.AuthorRepository;
import com.example.batis_demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthor(int size, int page) {
        int offSet = size * (page-1);
        return authorRepository.getAllAuthor(offSet,size);
    }
}
