package com.example.presentation;

import com.example.presentation.model.User;
import com.example.presentation.service.UserBalanceService;
import com.example.presentation.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class UserBalanceTest extends BaseTest {

    @Autowired
    private UserBalanceService userBalanceService;

    @Autowired
    private UserService userService;

    @Test
    public void testAddUserBalanceAndUser() throws Exception {
        userBalanceService.addUserBalanceAndUser(new User("Soul Goodman",18,"london"),new BigDecimal(1500));
    }

    @Test
    public void queryUserByNameAndAge(){
        List<User> uers = userService.getUsers();
        for (User uer : uers) {
            System.out.println(uer);
        }
    }

}
