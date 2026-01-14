package com.example.presentation.repository;

import com.example.presentation.model.User;
import com.example.presentation.config.SqlSessionTemplateConfig;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class UserRepository {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Transactional
    public void insert(User user) {
        //com.example.presentation.repository.user
        sqlSessionTemplate.insert("com.example.presentation.repository.UserRepository.addUser", user);
    }


    public List<User> queryUserByNameAndAge(Map<String, Object> param) {
        List<User> users = sqlSessionTemplate.selectList("com.example.presentation.repository.UserRepository.queryUserByNameAndAge", param);
        return users;
    }
}
