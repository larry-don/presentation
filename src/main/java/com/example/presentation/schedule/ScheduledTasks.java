package com.example.presentation.schedule;

import com.example.presentation.model.ContentZone;
import com.example.presentation.model.Data;
import com.example.presentation.model.MessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 原博客地址
 * https://segmentfault.com/a/1190000020192878
 */
@EnableScheduling
@Component
@Conditional(DomainUrlCondition.class)
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate：固定速率执行。每5秒执行一次。
     */
   /* @Scheduled(fixedRate = 5000)
    public void reportCurrentTimeWithFixedRate() {
        //默认一个线程跑定时任务
        log.info("Current Thread : {}", Thread.currentThread().getName());
        log.info("Fixed Rate Task : The time is now {}", dateFormat.format(new Date()));
    }*/

    /**
     * fixedDelay：固定延迟执行。距离上一次调用成功后2秒才执。
     */
    /*@Scheduled(fixedDelay = 2000)
    public void reportCurrentTimeWithFixedDelay() {
        try {
            TimeUnit.SECONDS.sleep(3);
            log.info("Fixed Delay Task : The time is now {}", dateFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * initialDelay:初始延迟。任务的第一次执行将延迟5秒，然后将以5秒的固定间隔执行。
     */
    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    public void reportCurrentTimeWithInitialDelay() {
        log.info("Fixed Rate Task with Initial Delay : The time is now {}", dateFormat.format(new Date()));
    }

    /**
     * cron：使用Cron表达式。　每分钟的1，2秒运行
     */
    /*@Scheduled(cron = "1-2 * * * * ? ")
    public void reportCurrentTimeWithCronExpression() {
        log.info("Cron Expression: The time is now {}", dateFormat.format(new Date()));
    }*/
    public static void sendMessage() {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            String messageContentExample = createMessageContentExample();
            ClassicHttpRequest httpPost = ClassicRequestBuilder.post("https://c2.yonyoucloud.com/yonbip-ec-link/intelligent-robot/system/send")
                    .addParameter("accessToken", "2404214923138695176")
                    .addParameter("domain", "iuap-metadata-import")
                    .setEntity(messageContentExample, ContentType.APPLICATION_JSON)
                    .addHeader("Content-Type", "application/json")
                    .build();
            httpclient.execute(httpPost, response -> {
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                final HttpEntity entity2 = response.getEntity();
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity2);
                return null;
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 创建消息内容示例
    public static String createMessageContentExample() {
        try {
            // 创建主对象
            MessageRequest messageRequest = new MessageRequest();
            messageRequest.setBusinessId("虽然文档注明非必填，但不填会报错");

            // 创建内容区域列表
            List<ContentZone> contentZones = new ArrayList<>();

            // 添加第一个文本视图
            ContentZone zone1 = new ContentZone();
            zone1.setType("textView");
            Data data1 = new Data();
            data1.setLevel(1);
            data1.setText("【今日值班人】：王春如");
            zone1.setData(data1);
            contentZones.add(zone1);

            // 添加第二个文本视图
            ContentZone zone2 = new ContentZone();
            zone2.setType("textView");
            Data data2 = new Data();
            data2.setLevel(1);
            data2.setText("【日期】：2025-11-14");
            zone2.setData(data2);
            contentZones.add(zone2);

            // 添加第三个文本视图
            ContentZone zone3 = new ContentZone();
            zone3.setType("textView");
            Data data3 = new Data();
            data3.setLevel(1);
            data3.setText("【本群使用须知】");
            zone3.setData(data3);
            contentZones.add(zone3);

            // 添加第四个文本视图
            ContentZone zone4 = new ContentZone();
            zone4.setType("textView");
            Data data4 = new Data();
            data4.setLevel(1);
            data4.setText("1.导入导出相关问题建议优先查阅检索ISP知识库：https://gfwiki.yyrd.com/pages/viewpage.action?pageId=102171555 和部门知识库：https://gfwiki.yyrd.com/pages/viewpage.action?pageId=42393894");
            zone4.setData(data4);
            contentZones.add(zone4);

            // 添加第五个文本视图
            ContentZone zone5 = new ContentZone();
            zone5.setType("textView");
            Data data5 = new Data();
            data5.setLevel(1);
            data5.setText("2.若还存在疑问，请在群中描述问题（包含环境、租户、账号、报错信息和BRP这些关键信息）并@值班人。我们会尽快分析和与您联系！！！");
            zone5.setData(data5);
            contentZones.add(zone5);

            // 设置内容区域
            messageRequest.setContentZone(contentZones);

            // 转换为JSON字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(messageRequest);

            // 使用Base64进行编码
            String encodedString = Base64.getEncoder().encodeToString(jsonString.getBytes("UTF-8"));

            //System.out.println("原始JSON: " + jsonString);
            //System.out.println("Base64编码后: " + encodedString);

            HashMap<String, Object> content = new HashMap<>();
            content.put("content", encodedString);
            content.put("timestamp", System.currentTimeMillis());
            content.put("extendType", "universalMessage");
            return objectMapper.writeValueAsString(content);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
