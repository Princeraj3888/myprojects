package com.exploretech.service;

import com.exploretech.model.Order;
import com.exploretech.orders.OrderBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MatchingEngineService {

    private final OrderBook orderBook = new OrderBook("AAPL");


    @KafkaListener(topics = "orders", groupId = "matching-group")
    public void processOrders(Order order){
        orderBook.addOrder(order);
        log.info("order matched: {}", order);
    }
}
