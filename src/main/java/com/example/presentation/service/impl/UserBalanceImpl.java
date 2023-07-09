package com.example.presentation.service.impl;

import com.example.presentation.model.User;
import com.example.presentation.model.UserBalance;
import com.example.presentation.repository.UserBalanceRepository;
import com.example.presentation.service.UserBalanceService;
import com.example.presentation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Slf4j
@Service
public class UserBalanceImpl implements UserBalanceService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBalanceRepository userBalanceRepository;

    @Override
    public void addUserBalance(UserBalance userBalance) throws IOException {
        userBalanceRepository.insert(userBalance);
    }

    @Override
    public void addUserBalanceAndUser(User user, BigDecimal balance) throws IOException {
        log.info("[addUserBalanceAndUser] begin!!!");
        //1.新增用户
        userService.addUser(user);
        //2.新增用户余额
        UserBalance userBalance = new UserBalance();
        userBalance.setName(user.getName());
        userBalance.setBalance(balance);
        this.addUserBalance(userBalance);
        log.info("[addUserBalanceAndUser] end!!!");
    }
}
