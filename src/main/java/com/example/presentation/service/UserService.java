package com.example.presentation.service;

import com.example.presentation.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
}
