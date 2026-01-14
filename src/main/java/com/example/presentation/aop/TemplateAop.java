package com.example.presentation.aop;

import com.example.presentation.annotaion.DoubleWrite;
import com.example.presentation.template.TemplateConvert;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
 * @Date 2024/5/23 12:34
 */
@Component
@Aspect
@Slf4j
public class TemplateAop {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(100));

    @Pointcut("@annotation(com.example.presentation.annotaion.DoubleWrite)")
    public void pointCut() {

    }

    @Around(value = "pointCut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = joinPoint.proceed();
        threadPoolExecutor.execute(() ->
        {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            DoubleWrite annotation = signature.getMethod().getAnnotation(DoubleWrite.class);
            Class<? extends TemplateConvert> instance = annotation.instance();
            try {
                TemplateConvert templateConvert = instance.newInstance();
                templateConvert.invoke(joinPoint.getArgs());
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            log.warn("templateAop逻辑执行完成");
        });
        return proceed;
    }
}
