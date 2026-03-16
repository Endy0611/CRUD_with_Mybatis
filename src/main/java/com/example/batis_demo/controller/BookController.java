package com.example.batis_demo.controller;


import com.example.batis_demo.model.entity.Book;
import com.example.batis_demo.model.request.BookRequest;
import com.example.batis_demo.model.response.ApiResponse;
import com.example.batis_demo.service.BookService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
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

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> saveBook(@RequestBody BookRequest bookRequest) {

        ApiResponse<Book> apiResponse = ApiResponse.<Book>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("success")
                .payload(bookService.saveBook(bookRequest))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<ApiResponse<Book>> deleteBookById(@PathVariable("book_id") Long bookId) {
        ApiResponse<Book> apiResponse = ApiResponse.<Book>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Deleted Book successfully!")
                .payload(bookService.deleteBookById(bookId))
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
