package com.example.demoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseModel<T> {
    private int status;
    private T data;
}
