package com.example.presentation.controller;

import com.example.presentation.model.User;
import com.example.presentation.service.UserBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2023/8/6 16:13
 */

@RestController
public class UserController {

    @Autowired
    private UserBalanceService userBalanceService;

    @RequestMapping("addUser")
    public void addUser(HttpServletResponse response) throws Exception {
        userBalanceService.addUserBalanceAndUser(new User("bob",8,"NY"),new BigDecimal(100));
    }
}
