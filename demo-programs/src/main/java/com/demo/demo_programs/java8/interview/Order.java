package com.demo.demo_programs.java8.interview;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String orderId;

    private List<Products> products;

    private LocalDateTime orderDateTime;

    private BigDecimal totalValue;

    public Order(String orderId, List<Products> products, LocalDateTime orderDateTime, BigDecimal totalValue) {
        this.orderId = orderId;
        this.products = products;
        this.orderDateTime = orderDateTime;
        this.totalValue = totalValue;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
