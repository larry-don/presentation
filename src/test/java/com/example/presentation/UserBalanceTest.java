package com.example.presentation;

import com.example.presentation.model.User;
import com.example.presentation.service.UserBalanceService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;

public class UserBalanceTest extends BaseTest {

    @Autowired
    private UserBalanceService userBalanceService;

    @Test
    public void testAddUserBalanceAndUser() throws IOException {
        userBalanceService.addUserBalanceAndUser(new User("peter",18,"london"),new BigDecimal(1000));
    }

}
