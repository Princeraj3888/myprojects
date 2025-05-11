package com.demo.demo_programs.java8.interview;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockIssueDetector {

    public static void main(String[] args){
        Map<String, Integer> orderStock = new HashMap<>();
        orderStock.put("P001", 100);
        orderStock.put("P002", 50);
        orderStock.put("P003", 120);

        List<Order> sampleOrders = new ArrayList<>();
        sampleOrders.add(new Order("001", List.of(
                new Products("P001", "Shoes", "Sports", 30, true, BigDecimal.valueOf(500)),
                new Products("P002", "Shoes", "Sports", 60, true, BigDecimal.valueOf(500))), LocalDateTime.now(), BigDecimal.valueOf(6000)));
        sampleOrders.add(new Order("002", List.of(new Products("P002", "Shirt", "Clothing", 40, true, BigDecimal.valueOf(500))), LocalDateTime.now(), BigDecimal.valueOf(6000)));
        sampleOrders.add(new Order("003", List.of(new Products("P003", "sun glasses", "Sports", 130, true, BigDecimal.valueOf(500))), LocalDateTime.now(), BigDecimal.valueOf(6000)));

        List<String> issueOrders =
                sampleOrders.stream()
                        .filter(order -> order.getProducts().stream()
                                .anyMatch(product -> {
                                    int availableStock = orderStock.get(product.getProductId());
                                    return availableStock < product.getQuantity();
                                }))
                        .map(Order::getOrderId).toList();

        System.out.println(issueOrders);
    }
}
