package com.example.presentation.repository;

import com.example.presentation.model.User;
import com.example.presentation.config.SqlSessionTemplateConfig;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserRepository {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Transactional
    public void insert(User user) {
        //com.example.presentation.repository.user
        sqlSessionTemplate.insert("com.example.presentation.repository.UserRepository.addUser", user);
    }
}
