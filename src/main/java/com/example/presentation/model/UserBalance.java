package com.example.presentation.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
public class UserBalance {
    private int id;
    private String name;
    private BigDecimal balance;
}
