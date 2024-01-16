package com.example.presentation.controller;


import com.example.presentation.model.User;
import com.example.presentation.service.UserService;
import com.example.presentation.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    private UserService userService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("ok")
    public void test1(@RequestBody User user, HttpServletResponse response) throws IOException {
        response.getWriter().write(user.toString());
    }
}
