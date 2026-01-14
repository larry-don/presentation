package com.example.presentation.order;

import com.example.presentation.annotaion.OperateLog;
import org.springframework.stereotype.Service;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 14:08
 */
@Service
public class OrderService {

    @OperateLog(desc = "保存订单", convert = SaveOrderConvert.class)
    public boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("保存订单成功");
        return true;
    }

    @OperateLog(desc = "更新订单", convert = UpdateOrderConvert.class)
    public boolean updateOrder(UpdateOrder updateOrder) {
        System.out.println("更新订单成功");
        return true;
    }
}
