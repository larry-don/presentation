package com.example.presentation.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/7/18 9:38
 */

@Configuration
public class CacheConfig {


    @Bean("systemCache")
    public Cache<String, Object> systemCache() {
        return Caffeine.newBuilder().build();
    }

    @Bean("systemCache123")
    public Cache<String, Object> systemCache123() {
        return Caffeine.newBuilder().build();
    }

}
