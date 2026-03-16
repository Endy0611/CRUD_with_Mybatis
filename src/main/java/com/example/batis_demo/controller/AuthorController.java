package com.example.batis_demo.controller;


import com.example.batis_demo.model.entity.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    @GetMapping
    public List<Author> getAllAuthor() {
        return null;
    }
}
