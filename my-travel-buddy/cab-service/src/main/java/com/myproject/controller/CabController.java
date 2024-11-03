package com.myproject.controller;

import com.myproject.entity.Cab;
import com.myproject.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cab")
public class CabController {

    private final CabService cabService;

    @Autowired
    public CabController(CabService cabService){
        this.cabService = cabService;
    }

    @PostMapping("/createCabDetails")
    public Cab createCabDetails(@RequestBody Cab cabDetails){
        return cabService.createCabDetails(cabDetails);
    }

    @GetMapping("/getAllCabDetails")
    public List<Cab> getAllCabDetails(){
        return cabService.getAllCabDetails();
    }

    @GetMapping("/getCabDetailsById/{cabId}")
    public Optional<Cab> getCabDetailsById(UUID cabId){
        return cabService.getCabDetailsById(cabId);
    }
}
