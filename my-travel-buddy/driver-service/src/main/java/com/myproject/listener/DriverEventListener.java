package com.myproject.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.service.DriverService;
import events.CabEvents;
import events.UpdateDriverEventStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DriverEventListener {

    private final String UPDATE_DRIVER_EVENT = "update-cab-events1";

    private DriverService driverService;

    public DriverEventListener(DriverService driverService){
        this.driverService = driverService;
    }

    @KafkaListener(topics = UPDATE_DRIVER_EVENT, groupId = "update-driver-group")
    public void driverEventListenerStatus(String message) throws JsonProcessingException {
        UpdateDriverEventStatus updateDriverEventStatus = new ObjectMapper().readValue(message, UpdateDriverEventStatus.class);

        System.out.println("updateDriverEventStatus: "+updateDriverEventStatus);

        driverService.updateDriverStatus(updateDriverEventStatus.getDriverId(), updateDriverEventStatus.getDriverStatus());
    }
}
