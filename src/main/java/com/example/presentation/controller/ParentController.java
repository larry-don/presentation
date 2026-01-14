package com.example.presentation.controller;

import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/6/26 15:43
 */
public class ParentController {

    @PostMapping(value = "parent/url", params = {"serviceCode","action!=listdetail"})
    public void test8(HttpServletResponse response) throws IOException {
        response.getWriter().write("old-move" + "\n");
    }
}
