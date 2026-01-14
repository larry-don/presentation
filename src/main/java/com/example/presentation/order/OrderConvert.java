package com.example.presentation.order;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 14:16
 */
public interface OrderConvert<PARAM> {
    OperateRecord convert(PARAM param);
}
