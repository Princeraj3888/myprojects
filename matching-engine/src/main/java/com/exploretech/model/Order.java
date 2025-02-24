package com.exploretech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private String traderId;
    private String stockSymbol;
    private int quantity;
    private BigDecimal price;
    private String orderType; // BUY or SELL

}
