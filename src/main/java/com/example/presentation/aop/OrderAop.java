package com.example.presentation.aop;

import com.example.presentation.annotaion.OperateLog;
import com.example.presentation.order.OperateRecord;
import com.example.presentation.order.OrderConvert;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 10:57
 */
@Component
@Aspect
public class OrderAop {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(100));

    @Pointcut("@annotation(com.example.presentation.annotaion.OperateLog)")
    public void orderServicePointCut() {
    }


    @Around(value = "orderServicePointCut()")
    public Object aroundUser(ProceedingJoinPoint pjp) throws Throwable {
        Object proceed = pjp.proceed();
        threadPoolExecutor.execute(() -> {
            MethodSignature signature = (MethodSignature) pjp.getSignature();
            OperateLog annotation = signature.getMethod().getAnnotation(OperateLog.class);
            Class<? extends OrderConvert> convert = annotation.convert();
            OrderConvert orderConvert = null;
            try {
                orderConvert = convert.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            OperateRecord operateRecord = orderConvert.convert(pjp.getArgs()[0]);
            operateRecord.setOperateType(annotation.desc());
            System.out.println("插入记录成功。。。");
            System.out.println(operateRecord);
        });
        return proceed;
    }
}
