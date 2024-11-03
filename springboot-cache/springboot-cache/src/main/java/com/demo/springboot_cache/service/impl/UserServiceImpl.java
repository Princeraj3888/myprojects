package com.demo.springboot_cache.service.impl;

import com.demo.springboot_cache.entity.User;
import com.demo.springboot_cache.exception.UserNotFoundException;
import com.demo.springboot_cache.repository.UserRepository;
import com.demo.springboot_cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUserDetails() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> retrievedUser = userRepository.findById(id);
        if(retrievedUser.isPresent()){
            return retrievedUser.get();
        }else{
            throw new UserNotFoundException("user not found with available id: "+id);
        }
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        User retrievedUser = userRepository.getReferenceById(id);
        if(retrievedUser !=null ){
            retrievedUser.setUserName(user.getUserName());
            retrievedUser.setAge(user.getAge());
            retrievedUser.setPassword(user.getPassword());
            log.info("details: "+retrievedUser);
            return userRepository.save(retrievedUser);
        }else{
           return new User();
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
