package com.example.presentation.service.impl;

import com.example.presentation.model.User;
import com.example.presentation.repository.UserRepository;
import com.example.presentation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public void addUser(User user) {
        log.info("[addUser] begin!!!");
        userRepository.insert(user);
        log.info("[addUser] end!!!");
    }


    @Override
    public List<User> getUsers(){
        Map<String,Object> param = new HashMap<>();
        //param.put("name","peter");
        param.put("age",18);
        List<User> users = userRepository.queryUserByNameAndAge(param);
        return users;
    }
}
