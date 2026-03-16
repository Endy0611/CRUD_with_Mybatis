package com.example.batis_demo.service.Impl;

import com.example.batis_demo.model.entity.Book;
import com.example.batis_demo.model.response.ApiResponse;
import com.example.batis_demo.repository.BookRepository;
import com.example.batis_demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks(int size, int page) {
        int offSet = size * (page-1);
        return bookRepository.getAllBook(offSet,size);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.getBookById(bookId);
    }

}
