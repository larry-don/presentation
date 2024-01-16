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

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 10:57
 */
@Component
@Aspect
public class UserAop {

    @Pointcut("@annotation(com.example.presentation.annotaion.OperateLog)")
    public void orderServicePointCut() {
    }


    @Around(value = "orderServicePointCut()")
    public Object aroundUser(ProceedingJoinPoint pjp) throws Throwable {
        Object proceed = pjp.proceed();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        OperateLog annotation = signature.getMethod().getAnnotation(OperateLog.class);
        Class<? extends OrderConvert> convert = annotation.convert();
        OrderConvert orderConvert = convert.newInstance();
        OperateRecord operateRecord = orderConvert.convert(pjp.getArgs()[0]);
        operateRecord.setOperateType(annotation.desc());
        System.out.println("插入记录成功。。。");
        System.out.println(operateRecord);
        return proceed;
    }
}
