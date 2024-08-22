package com.demo.springboot_cache.service;

import com.demo.springboot_cache.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUserDetails();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}
