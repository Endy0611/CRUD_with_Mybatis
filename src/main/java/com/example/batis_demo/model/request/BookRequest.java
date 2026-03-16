package com.example.batis_demo.model.request;

import com.example.batis_demo.model.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private Instant publishDate;
    private Author author;
}
