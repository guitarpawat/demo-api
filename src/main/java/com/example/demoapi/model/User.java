package com.example.demoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private BigDecimal money;
    private List<Hobby> hobbies;
    private List<String> favouriteFoods;
    private String additionalInfo;
}
