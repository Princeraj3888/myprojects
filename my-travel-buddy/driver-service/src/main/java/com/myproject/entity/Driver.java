package com.myproject.entity;

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
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driverId")
    private UUID driverId;

    @Column(name = "driverName")
    private String driverName;

    @Column(name = "driverEmail")
    private String driverEmail;

    @Column(name = "driverLocation")
    private String driverLocation;

    @Enumerated(EnumType.STRING)
    @Column(name = "driverStatus")
    private CommonStatus driverStatus;
}
