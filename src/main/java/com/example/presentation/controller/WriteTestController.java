package com.example.presentation.controller;


import com.example.presentation.model.User;
import com.example.presentation.service.UserService;
import com.example.presentation.service.impl.TestService;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class WriteTestController {

    private final TestService testService;

    private UserService userService;

    @Autowired
    private Cache<String, Object> systemCache;

    @Autowired
    public WriteTestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("ok")
    public void test1(@RequestBody User user, HttpServletResponse response) throws IOException {
        response.getWriter().write(user.toString());
    }

    @PostMapping(value = "abc")
    public void test2(HttpServletResponse response) throws IOException {
        Object name = systemCache.getIfPresent("name");
        response.getWriter().write("test2" + "\n");
    }

    @PostMapping(value = "abc", params = {"action!=listdetail"})
    public void test3(HttpServletResponse response) throws IOException {
        response.getWriter().write("test3" + "\n");
    }


    @PostMapping(value = "abc", params = {"action!=listdetail", "!router"})
    public void test7(HttpServletResponse response) throws IOException {
        response.getWriter().write("test7" + "\n");
    }


    @PostMapping(value = "abc", params = {"streaming=true", "serviceCode", "action!=listdetail"})
    public void test10(HttpServletResponse response) throws IOException {
        response.getWriter().write("test10" + "\n");
    }

    @PostMapping(value = "abc", params = {"!feV", "!xportTemplate", "streaming=true", "serviceCode", "action!=listdetail"})
    public void test8(HttpServletResponse response) throws IOException {
        response.getWriter().write("old-move" + "\n");
    }

    @PostMapping(value = "abc", params = {"serviceCode", "action!=listdetail", "!feV", "!xportTemplate", "!xportCompatibleVersion"})
    public void test9(HttpServletResponse response) throws IOException {
        response.getWriter().write("new-streaming" + "\n");
    }

   /* @PostMapping(value = "abc", params = {"!action","serviceCode"})
    public void test6(HttpServletResponse response) throws IOException {
        response.getWriter().write("test6" + "\n");
    }

    @PostMapping(value = "abc", params = {"streaming","!action"})
    public void test4(HttpServletResponse response) throws IOException {
        response.getWriter().write("test4" + "\n");
    }


    @PostMapping(value = "abc", params = {"streaming=true", "action=listdetail"})
    public void test5(HttpServletResponse response) throws IOException {
        response.getWriter().write("test5" + "\n");
    }*/

    @GetMapping("/test10")
    public String test10(String name) {
        return name + "test10";
    }

    @GetMapping(value = "/test11")
    public void test11(String name, HttpServletResponse response) throws IOException {
        response.getWriter().write(name + "\n");
    }

}
