package com.demo.springboot_cache.controller;

import com.demo.springboot_cache.entity.User;
import com.demo.springboot_cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUserDetails(){
        return userService.getAllUserDetails();
    }
}
