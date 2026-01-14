package com.example.presentation.gzip;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/2/1 9:31
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册filter
 */
@Configuration
public class FilterRegistration {

    @Autowired
    private GzipFilter gzipFilter;

    @Bean
    public FilterRegistrationBean<GzipFilter> gzipFilterRegistrationBean() {
        FilterRegistrationBean<GzipFilter> registration = new FilterRegistrationBean<>();
        //Filter可以new，也可以使用依赖注入Bean
        registration.setFilter(gzipFilter);
        //过滤器名称
        registration.setName("gzipFilter");
        //拦截路径
        registration.addUrlPatterns("/*");
        //设置顺序
        registration.setOrder(1);
        return registration;
    }
}