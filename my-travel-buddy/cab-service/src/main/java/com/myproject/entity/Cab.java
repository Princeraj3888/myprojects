package com.myproject.entity;

import cab.CabTypes;
import common.dto.CommonStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cab_id")
    private UUID cabId;

    @Column(name = "driver_id")
    private UUID driverId;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Enumerated
    @Column(name = "cab_types")
    private CabTypes cabTypes;

    @Enumerated(EnumType.STRING)
    @Column(name = "cab_status")
    private CommonStatus cabStatus;
}
