package com.myproject.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.entity.Cab;
import com.myproject.service.CabService;
import common.dto.CommonStatus;
import events.CabEvents;
import events.UpdateDriverEventStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CabListener {

    private final String ADD_CAB_DETAILS = "create-cab-events1";
    private final String UPDATE_DRIVER_EVENT = "update-cab-events1";

    private CabService cabService;
    private KafkaTemplate<String, UpdateDriverEventStatus> updateDriverEventStatusKafkaTemplate;

    private CabListener(CabService cabService, KafkaTemplate updateDriverEventStatusKafkaTemplate){
        this.cabService = cabService;
        this.updateDriverEventStatusKafkaTemplate = updateDriverEventStatusKafkaTemplate;
    }

    @KafkaListener(topics = ADD_CAB_DETAILS, groupId = "mybuddy-group")
    private void addCabEvents(String event) throws JsonProcessingException {
        CabEvents cabEvents = new ObjectMapper().readValue(event, CabEvents.class);
        System.out.println(cabEvents);

        boolean exists = cabService.existsByRegistrationNumberAndCabStatus(cabEvents.getRegistrationNumber(), CommonStatus.SUCCESS);

        CommonStatus status = CommonStatus.SUCCESS;
        if(exists){
            status = CommonStatus.FAILED;
        }

        saveCabDetailsAndUpdateDriverStatus(cabEvents, status);
    }

    private void saveCabDetailsAndUpdateDriverStatus(CabEvents cabEvents, CommonStatus status) {
        Cab cab = saveCabDetails(cabEvents, status);
        updateDriverEvent(cab, status);
    }

    private void updateDriverEvent(Cab cab, CommonStatus status) {
        UpdateDriverEventStatus updateDriverEventStatus = UpdateDriverEventStatus.builder()
                .driverId(cab.getDriverId())
                .driverStatus(status)
                .build();
        updateDriverEventStatusKafkaTemplate.send(UPDATE_DRIVER_EVENT, updateDriverEventStatus);
    }

    private Cab saveCabDetails(CabEvents cabEvents, CommonStatus status) {
        return cabService.createCabDetails(Cab.builder()
                .driverId(cabEvents.getDriverId())
                .registrationNumber(cabEvents.getRegistrationNumber())
                .cabTypes(cabEvents.getCabTypes())
                .cabStatus(status)
                .build());
    }


}
