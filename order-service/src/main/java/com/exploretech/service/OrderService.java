package com.exploretech.service;

import com.exploretech.event.OrderEvent;
import com.exploretech.event.OrderEventFactory;
import com.exploretech.event.OrderEventHandler;
import com.exploretech.model.Order;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderService {
    private final Disruptor<OrderEvent> disruptor;

    public OrderService() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        OrderEventFactory orderEventFactory = new OrderEventFactory();
        int bufferSize = 1024;

        disruptor = new Disruptor<>(orderEventFactory, bufferSize, executorService);
        disruptor.handleEventsWith(new OrderEventHandler());
        disruptor.start();
    }

    public void publishOrder(Order order){
        disruptor.publishEvent((event, sequence) -> event.setOrder(order));
    }
}
