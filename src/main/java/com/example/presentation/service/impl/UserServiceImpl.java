package com.example.presentation.service.impl;

import com.example.presentation.model.User;
import com.example.presentation.repository.UserRepository;
import com.example.presentation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) throws IOException {
        log.info("[addUser] begin!!!");
        userRepository.insert(user);
        log.info("[addUser] end!!!");
    }
}
