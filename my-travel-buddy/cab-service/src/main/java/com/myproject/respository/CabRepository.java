package com.myproject.respository;

import com.myproject.entity.Cab;
import common.dto.CommonStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CabRepository extends JpaRepository<Cab, UUID> {

    boolean existsByRegistrationNumberAndCabStatus(String registrationNumber, CommonStatus success);
}
