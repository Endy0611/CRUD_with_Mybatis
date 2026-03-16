package com.example.batis_demo.controller;


import com.example.batis_demo.model.entity.Book;
import com.example.batis_demo.model.response.ApiResponse;
import com.example.batis_demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks(@RequestParam int size, @RequestParam int page) {
        List<Book> bookList = bookService.getAllBooks(size, page);
        ApiResponse<List<Book>> apiResponse = ApiResponse.<List<Book>>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("success")
                .payload(bookList)
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{book-id}")
    public ResponseEntity<ApiResponse<Book>> getBookById(@PathVariable ("book-id") Long bookId) {

        ApiResponse<Book> apiResponse = ApiResponse.<Book>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("success")
                .payload(bookService.getBookById(bookId))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
