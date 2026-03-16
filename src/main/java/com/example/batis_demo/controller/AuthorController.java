package com.example.batis_demo.controller;


import com.example.batis_demo.model.entity.Author;
import com.example.batis_demo.model.response.ApiResponse;
import com.example.batis_demo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Author>>> getAllAuthor(@RequestParam (defaultValue = "1") int size, @RequestParam int page) {

        List<Author> authorList = authorService.getAllAuthor(size, page);

        ApiResponse<List<Author>> apiResponse = new ApiResponse<>(true, HttpStatus.OK, "success", authorList, Instant.now());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
