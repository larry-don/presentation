package com.example.presentation.service;

import com.example.presentation.model.User;

import java.io.IOException;

public interface UserService {
    void addUser(User user) throws IOException;
}
