package com.demo.springboot_cache.controller;

import com.demo.springboot_cache.entity.User;
import com.demo.springboot_cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
@CacheConfig(cacheNames = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUserDetails(){
        return userService.getAllUserDetails();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id")
    public User getUserById(@PathVariable Long id){
        log.info("fetching data from database for id: ",id);
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    @CachePut(key = "#id")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
