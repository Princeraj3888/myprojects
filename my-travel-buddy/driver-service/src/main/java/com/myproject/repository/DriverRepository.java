package com.myproject.repository;

import com.myproject.entity.Driver;
import common.dto.CommonStatus;
import events.UpdateDriverEventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {

    @Modifying
    @Query("update Driver d set d.driverStatus = :driverStatus where d.driverId= :driverId")
    int updateDriverStatus(@Param("driverId") UUID driverId, @Param("driverStatus") CommonStatus driverStatus);
}
