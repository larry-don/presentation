package com.example.presentation.order;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 14:21
 */
public class SaveOrderConvert implements OrderConvert<SaveOrder> {
    @Override
    public OperateRecord convert(SaveOrder saveOrder) {
        OperateRecord operateRecord = new OperateRecord();
        operateRecord.setId(saveOrder.getOrderNo());
        return operateRecord;
    }
}
