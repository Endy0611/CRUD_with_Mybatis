package com.example.batis_demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long id;
    private String title;
    private Instant publishDate;
    private Author author;
}
