package com.demo.springboot_cache.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String postDescription;

    private Timestamp postDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
