package com.example.presentation.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private String address;

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
