package com.example.presentation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@Slf4j
public class PresentationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PresentationApplication.class, args);


        Map<String, String> container = new HashMap<>();
        container.put("name", "bob");
        container.put("gender", "male");
        Map<String, String> map = new HashMap<>(container);

        System.out.println("启动完成啦啦啦啦啦");
        log.debug("项目启动时间：{}",new SimpleDateFormat("HH:mm:ss").format(new Date()));

    }

}
