package com.example.batis_demo.controller;


import com.example.batis_demo.model.entity.Author;
import com.example.batis_demo.model.request.AuthorRequest;
import com.example.batis_demo.model.response.ApiResponse;
import com.example.batis_demo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import javax.swing.text.html.HTML;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    private final AuthorService authorService;
    private final JsonMapper.Builder builder;

    public AuthorController(AuthorService authorService, JsonMapper.Builder builder) {
        this.authorService = authorService;
        this.builder = builder;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Author>>> getAllAuthor(@RequestParam (defaultValue = "1") int size, @RequestParam int page) {

        List<Author> authorList = authorService.getAllAuthor(size, page);

        ApiResponse<List<Author>> apiResponse = new ApiResponse<>(true, HttpStatus.OK, "success", authorList, Instant.now());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{author-id}")
    public ResponseEntity<ApiResponse<Author>> getAuthorById(@PathVariable("author-id") Long authorId) {

        ApiResponse<Author> apiResponse = ApiResponse.<Author>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("success")
                .payload(authorService.getAuthorById(authorId))
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Author>> saveAuthor(@RequestBody AuthorRequest authorRequest) {
        ApiResponse<Author> apiResponse = ApiResponse.<Author>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("success")
                .payload(authorService.saveAuthor(authorRequest))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
