package com.example.batis_demo.service;

import com.example.batis_demo.model.entity.Book;
import com.example.batis_demo.model.request.BookRequest;
import com.example.batis_demo.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks(int size, int page);

    Book getBookById(Long bookId);

    Book saveBook(BookRequest bookRequest);

    Book deleteBookById(Long bookId);
}
