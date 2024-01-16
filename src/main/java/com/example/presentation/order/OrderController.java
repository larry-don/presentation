package com.example.presentation.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/1/15 14:52
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public Object saveOrder(@RequestBody SaveOrder saveOrder) {
        return orderService.saveOrder(saveOrder);
    }

    @PostMapping("/update")
    public Object updateOrder(@RequestBody UpdateOrder updateOrder) {
        return orderService.updateOrder(updateOrder);
    }

}
