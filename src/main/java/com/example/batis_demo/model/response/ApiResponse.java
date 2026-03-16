package com.example.batis_demo.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T> {
    private boolean success;
    private HttpStatus status;
    private String message;
    private T payload;
    private Instant timestamp;
}
