package com.myproject.controller;

import com.myproject.entity.Driver;
import com.myproject.service.DriverService;
import driver.DriverDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping("/saveDriverDetails")
    public String saveDriverDetails(@RequestBody DriverDTO driverDTO){
        return driverService.saveDriver(driverDTO);
    }

    @GetMapping("/getAllDriverDetails")
    public List<Driver> getAllDriverDetails(){
        return driverService.getAllDriverDetails();
    }

    @GetMapping("/getDriver/{driverId}")
    public Optional<Driver> getDriverById(UUID driverId){
        return driverService.getDriverDetailsById(driverId);
    }

}
