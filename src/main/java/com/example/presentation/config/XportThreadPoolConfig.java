package com.example.presentation.config;

import com.alibaba.excel.util.BooleanUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.RejectedExecutionHandler;

/**
 * 本类用于
 *
 * @author liuhao
 * @since 2024/04/09 15:00
 */
@Data
@Slf4j
@FieldNameConstants
@NoArgsConstructor
public class XportThreadPoolConfig {

    private Integer maxSize = 5;

    private Duration keepAliveTime = Duration.ofMinutes(2);

    private Integer queueSize = 500;

    private String threadNamePattern;

    /**
     * 专属化部署时，降级使用的线程池
     * null表示不降级
     */


    /**
     * 这个字段不能序列化，存在不同实现，反序列化会丢失类型
     */
    @JsonIgnore
    private transient RejectedExecutionHandler rejectPolicy;

    /**
     * 公平队列开关，使用XportFairBlockingQueue
     * 租户间绝对公平，租户内按公式计算优先级
     */
    private Boolean useFairQueue = false;

    public XportThreadPoolConfig(Integer maxSize, Duration keepAliveTime, Integer queueSize, String threadNamePattern, RejectedExecutionHandler rejectPolicy) {
        this.maxSize = maxSize;
        this.keepAliveTime = keepAliveTime;
        this.queueSize = queueSize;
        this.threadNamePattern = threadNamePattern;
        this.rejectPolicy = rejectPolicy;
    }

    public XportThreadPoolConfig(Integer maxSize, Duration keepAliveTime, Integer queueSize, String threadNamePattern, RejectedExecutionHandler rejectPolicy, Boolean useFairQueue) {
        this.maxSize = maxSize;
        this.keepAliveTime = keepAliveTime;
        this.queueSize = queueSize;
        this.threadNamePattern = threadNamePattern;
        this.rejectPolicy = rejectPolicy;
        this.useFairQueue = BooleanUtils.isTrue(useFairQueue);
    }


    public String getThreadNamePattern() {
        if (threadNamePattern == null) {
            return null;
        }
        if (threadNamePattern.contains("%d")) {
            return threadNamePattern;
        }
        if (threadNamePattern.endsWith("-")) {
            return threadNamePattern + "%d";
        }
        return threadNamePattern + "-%d";
    }
}
