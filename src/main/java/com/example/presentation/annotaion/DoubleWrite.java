package com.example.presentation.annotaion;

import com.example.presentation.template.TemplateConvert;

import java.lang.annotation.*;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/5/23 12:29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DoubleWrite {
    //String desc() default "";

    Class<? extends TemplateConvert> instance();
}
