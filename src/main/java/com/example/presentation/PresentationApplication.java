package com.example.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PresentationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PresentationApplication.class, args);


        Map<String,String> container = new HashMap<>();
        container.put("name","bob");
        container.put("gender","male");
        Map<String,String> map = new HashMap<>(container);

    }

}
