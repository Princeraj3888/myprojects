package com.myproject.service;

import com.myproject.entity.Driver;
import com.myproject.repository.DriverRepository;
import common.dto.CommonStatus;
import driver.DriverDTO;
import events.CabEvents;
import events.UpdateDriverEventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    private KafkaTemplate<String, CabEvents> kafkaTemplate;

    private final String ADD_CAB_DETAILS = "create-cab-events1";

    @Autowired
    public DriverService(DriverRepository driverRepository, KafkaTemplate<String, CabEvents> kafkaTemplate){
        this.driverRepository = driverRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public String saveDriver(DriverDTO driverDTO){

        Driver driver = driverRepository.save(Driver.builder()
                        .driverEmail(driverDTO.getDriverEmail())
                        .driverName(driverDTO.getDriverName())
                        .driverLocation(driverDTO.getDriverLocation())
                        .driverStatus(CommonStatus.PENDING)
                .build());

        CabEvents cabEvents = CabEvents.builder().driverId(driver.getDriverId())
                .cabTypes(driverDTO.getCabDTO().getCabTypes())
                .registrationNumber(driverDTO.getCabDTO().getRegistrationNumber())
                .build();

        kafkaTemplate.send(ADD_CAB_DETAILS, cabEvents);
        return "Driver details driverId: "+driver.getDriverId()+" processed";
    }

    public List<Driver> getAllDriverDetails() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverDetailsById(UUID driverId) {
        return driverRepository.findById(driverId);
    }

    @Transactional
    public int updateDriverStatus(UUID driverId, CommonStatus driverStatus) {

        return driverRepository.updateDriverStatus(driverId, driverStatus);
    }
}