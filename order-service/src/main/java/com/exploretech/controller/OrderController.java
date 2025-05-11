package com.exploretech.controller;

import com.exploretech.model.Order;
import com.exploretech.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService = new OrderService();

    @PostMapping
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        orderService.publishOrder(order);
        return "Order Received: "+order.getOrderId();
    }
}
