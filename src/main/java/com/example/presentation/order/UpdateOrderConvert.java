package com.example.presentation.order;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 14:23
 */
public class UpdateOrderConvert implements OrderConvert<UpdateOrder> {

    @Override
    public OperateRecord convert(UpdateOrder updateOrder) {
        OperateRecord operateRecord = new OperateRecord();
        operateRecord.setId(updateOrder.getId());
        operateRecord.setOperateType(updateOrder.getOrderName());
        return operateRecord;
    }
}
