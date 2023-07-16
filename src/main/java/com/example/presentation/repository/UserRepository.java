package com.example.presentation.repository;

import com.example.presentation.model.User;
import com.example.presentation.util.SqlHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserRepository {


    public void insert(User user) throws IOException {
        //com.example.presentation.repository.user
        SqlHelper.getSqlSession().insert("com.example.presentation.repository.UserRepository.addUser",user);
    }
}
