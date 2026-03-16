package com.example.batis_demo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private Long authorId;
    private String name;
    private String gender;
}
