package com.example.presentation.annotaion;

import com.example.presentation.order.OrderConvert;

import java.lang.annotation.*;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 10:40
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface OperateLog {
    String desc() default "";

    Class<? extends OrderConvert> convert();
}
