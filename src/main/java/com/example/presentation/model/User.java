package com.example.presentation.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private String address;

    private Date pubts;

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
