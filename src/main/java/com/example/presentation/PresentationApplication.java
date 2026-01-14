package com.example.presentation;

import com.example.presentation.config.MyProperties;
import com.example.presentation.config.XportCommonProperties;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableScheduling
@EnableConfigurationProperties
@Slf4j
public class PresentationApplication {

    @Autowired
    @Qualifier("systemCache")
    private Cache<String, Object> systemCache1;

    @Autowired
    private MyProperties myProperties;

    @Autowired
    private XportCommonProperties commonProperties;

    public static void main(String[] args) {
        SpringApplication.run(PresentationApplication.class, args);

        System.out.println("启动完成啦啦啦啦啦");
        log.debug("项目启动时间：{}", new SimpleDateFormat("HH:mm:ss").format(new Date()));

    }

    @PostConstruct
    public void init() {
        System.out.println("配置" + myProperties.getNestedConfigs());
        System.out.println("配置" + myProperties.getNestedConfigMap());
        System.out.println("配置" + myProperties.getMetaInfoNestedConfigMap());
        System.out.println(commonProperties.getConfiguration());
        systemCache1.put("name", "cuikair");
        System.out.println("缓存写入成功");
    }

}
