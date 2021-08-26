package com.example.demoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hobby {
    private String name;
    private boolean isOutdoor;
}
