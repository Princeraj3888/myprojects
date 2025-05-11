package com.demo.demo_programs.java8.interview;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args){

        List<Order> orderList = generateOrders();
        generateReport(orderList);
    }

    private static void generateReport(List<Order> orderList) {

        Map<String, Integer> filterOrders = orderList.stream()
                .filter(order -> order.getOrderDateTime().isAfter(LocalDateTime.now().minusHours(24)))
                .filter(order -> (order.getTotalValue().compareTo(BigDecimal.valueOf(500)) > 0))
                .flatMap(order -> order.getProducts().stream())
                .filter(products -> products.isInStock())
                .collect(Collectors.groupingBy(Products::getCategory, Collectors.summingInt(Products::getQuantity)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println(filterOrders);

    }

    private static List<Order> generateOrders() {

        Order order1 = new Order("order1",
                List.of(new Products("1", "iPhone", "electronics", 1, true, BigDecimal.valueOf(70000)),
                        new Products("2", "HeadPhone", "electronics", 3, true, BigDecimal.valueOf(1000)),
                        new Products("3", "USB", "electronics", 5, true, BigDecimal.valueOf(1000))),
                LocalDateTime.now().minusHours(3),
                BigDecimal.valueOf(78000));

        Order order2 = new Order("order2",
                List.of(new Products("4", "sun glasses", "sports", 2, true, BigDecimal.valueOf(1000)),
                        new Products("5", "shoes", "sports", 3, false, BigDecimal.valueOf(2000)),
                        new Products("6", "bat and ball", "sports", 1, true, BigDecimal.valueOf(400))),
                LocalDateTime.now().minusHours(2),
                BigDecimal.valueOf(9000));

        Order order3 = new Order("order3",
                List.of(new Products("11", "hair dryer", "electronics", 3, true, BigDecimal.valueOf(3000))),
                LocalDateTime.now().minusHours(7),
                BigDecimal.valueOf(400));

        Order order5 = new Order("order5",
                List.of(new Products("12", "watch", "electronics", 3, true, BigDecimal.valueOf(3000))),
                LocalDateTime.now().minusHours(27),
                BigDecimal.valueOf(9000));

        Order order4 = new Order("order4",
                List.of(new Products("21", "jeans", "fabric", 2, true, BigDecimal.valueOf(1000)),
                        new Products("22", "tshirt", "fabric", 2, true, BigDecimal.valueOf(1000)),
                        new Products("23", "jacket", "fabric", 2, true, BigDecimal.valueOf(1000))),
                LocalDateTime.now().minusHours(5),
                BigDecimal.valueOf(6000));

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1); orderList.add(order2); orderList.add(order3); orderList.add(order4);

        return orderList;
    }
}
