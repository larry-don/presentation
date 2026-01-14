package com.example.presentation.service;

import com.example.presentation.model.User;
import com.example.presentation.model.UserBalance;

import java.io.IOException;
import java.math.BigDecimal;

public interface UserBalanceService {
    void addUserBalance(UserBalance userBalance) throws IOException;
    void addUserBalanceAndUser(User user, BigDecimal balance) throws IOException;
}
