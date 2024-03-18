package com.example.presentation.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 本类用于定时任务执行场景验证，场景如下：
 * 方法的定时器设定的固定速率是每5秒执行一次。这个方法现在要执行下面四个任务，四个任务的耗时是：6 s、6s、 2s、 3s，请问这些任务默认情况下（单线程）将如何被执行？
 * @Author larry
 * @Date 2024/2/4 14:22
 */
@Component
public class ScheduleVerify {
    private static final Logger log = LoggerFactory.getLogger(AsyncScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private List<Integer> index = Arrays.asList(6, 6, 2, 3);
    int i = 0;

    /*@Scheduled(fixedRate = 5000)
    public void reportCurrentTimeWithFixedRate() {
        if (i == 0) {
            log.info("Start time is {}", dateFormat.format(new Date()));
        }
        if (i < 5) {
            try {
                TimeUnit.SECONDS.sleep(index.get(i));
                log.info("Fixed Rate Task : The time is now {}", dateFormat.format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }*/
}
