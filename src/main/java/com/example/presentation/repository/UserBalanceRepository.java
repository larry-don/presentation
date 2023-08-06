package com.example.presentation.repository;

import com.example.presentation.model.UserBalance;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserBalanceRepository {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Transactional
    public void insert(UserBalance userBalance) {
        sqlSessionTemplate.insert("com.example.presentation.repository.UserBalanceRepository.addUserBalance", userBalance);
    }
}
