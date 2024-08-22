package com.demo.springboot_cache.repository;

import com.demo.springboot_cache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
