package com.myproject.service;

import com.myproject.entity.Cab;
import com.myproject.respository.CabRepository;
import common.dto.CommonStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CabService {

    private final CabRepository cabRepository;

    @Autowired
    public CabService(CabRepository cabRepository){
        this.cabRepository = cabRepository;
    }

    public Cab createCabDetails(Cab cabDetails) {
        return cabRepository.save(cabDetails);

    }

    public List<Cab> getAllCabDetails() {
        return cabRepository.findAll();
    }

    public Optional<Cab> getCabDetailsById(UUID cabId) {
        return cabRepository.findById(cabId);
    }

    public boolean existsByRegistrationNumberAndCabStatus(String registrationNumber, CommonStatus success) {
        return cabRepository.existsByRegistrationNumberAndCabStatus(registrationNumber, success);
    }
}
