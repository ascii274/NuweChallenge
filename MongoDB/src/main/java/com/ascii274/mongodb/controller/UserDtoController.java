package com.ascii274.mongodb.controller;

import com.ascii274.mongodb.repository.UserRepository;

import com.ascii274.mongodb.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/nuwechallenges/api/v1/mongodb")
public class UserDtoController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/test")
    public String test(){
        return "Hello testing";
    }

    @GetMapping(value = "/get-users")
    public List<UserDto> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "user")
    public UserDto createUser(@RequestBody UserDto userDto){
        return userRepository.save(userDto);

    }

    public void deleteUser(){

    }

    public void getUser(){

    }

    public void updateUser(){

    }
}
