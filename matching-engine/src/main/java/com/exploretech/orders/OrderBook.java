package com.exploretech.orders;

import com.exploretech.model.Order;
import net.openhft.chronicle.map.ChronicleMap;

import java.util.concurrent.ConcurrentHashMap;

public class OrderBook {

    private final ConcurrentHashMap<String, ChronicleMap<Long, Order>> booking = new ConcurrentHashMap<>();

    public OrderBook(String stockSymbol){
        booking.put(stockSymbol, ChronicleMap.of(Long.class, Order.class)
                .entries(1000)
                .averageValue(new Order())
                .create());
    }

    public void addOrder(Order order){
        booking.get(order.getStockSymbol()).put(System.nanoTime(), order);
    }
}
