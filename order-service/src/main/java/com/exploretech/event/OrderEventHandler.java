package com.exploretech.event;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderEventHandler implements EventHandler<OrderEvent> {
    @Override
    public void onEvent(OrderEvent orderEvent, long sequence, boolean endOfBatch) throws Exception {
        log.info("processing order: {}", orderEvent.getOrder());
    }
}
