package com.exploretech.event;

import com.exploretech.model.Order;
import lombok.Data;

@Data
public class OrderEvent {
    private Order order;
}
