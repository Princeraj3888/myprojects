package com.demo.demo_programs.java8.interview;

import java.math.BigDecimal;

public class Products {

    private String productId;
    private String name;
    private String category;
    private int quantity;
    private boolean inStock;
    private BigDecimal price;

    public Products(String productId, String name, String category, int quantity, boolean inStock, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.inStock = inStock;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
