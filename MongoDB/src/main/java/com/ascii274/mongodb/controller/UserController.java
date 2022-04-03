package com.ascii274.mongodb.controller;

import com.ascii274.mongodb.model.User;
import com.ascii274.mongodb.repository.UserRepository;
import com.ascii274.mongodb.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/nuwechallenges/api/v1/mongodb")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/test")
    public String test(){
        return "Hello testing";
    }

    @GetMapping(value = "/get-all-users")
    public List<User> getUsers(){
        return userServiceImpl.findAllUsers();
    }

    @GetMapping(value = "/get-user/{username}")
    public User getUser(@PathVariable("username") String username){
        return   userServiceImpl.findByUsername(username);
    }

    @PostMapping(value = "/user")
    public Boolean createUser(@RequestBody User user){
        return userServiceImpl.saveUser(user);
    }

    @DeleteMapping(value="/delete/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id){
        return  userServiceImpl.deleteById(id);
    }


}
