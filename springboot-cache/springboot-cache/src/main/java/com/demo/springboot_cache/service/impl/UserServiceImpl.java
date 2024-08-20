package com.demo.springboot_cache.service.impl;

import com.demo.springboot_cache.entity.User;
import com.demo.springboot_cache.repository.UserRepository;
import com.demo.springboot_cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUserDetails() {
        return userRepository.findAll();
    }
}
