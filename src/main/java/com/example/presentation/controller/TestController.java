package com.example.presentation.controller;


import com.example.presentation.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("ok")
    public void test1(@RequestBody User user, HttpServletResponse response) throws IOException {
        response.getWriter().write(user.toString());
    }
}
