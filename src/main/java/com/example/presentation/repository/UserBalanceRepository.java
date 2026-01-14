package com.example.presentation.repository;

import com.example.presentation.model.User;
import com.example.presentation.model.UserBalance;
import com.example.presentation.util.SqlHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserBalanceRepository {

    public void insert(UserBalance userBalance) throws IOException {
        SqlHelper.getSqlSession().insert("com.example.presentation.model.UserBalance.addUserBalance",userBalance);
    }
}
