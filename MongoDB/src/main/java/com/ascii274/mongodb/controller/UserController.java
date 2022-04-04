package com.ascii274.mongodb.controller;

import com.ascii274.mongodb.model.User;
import com.ascii274.mongodb.repository.UserRepository;
import com.ascii274.mongodb.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    /**
     * To show username data
     * @param username
     * @return
     */
    @GetMapping(value = "/get-user/{username}")
    public User getUser(@PathVariable("username") String username){
        return   userServiceImpl.findByUsername(username);
    }

    /**
     * To create new user
     * @param user
     * @return
     */
    @PostMapping(value = "/user")
    public Boolean createUser(@RequestBody User user){
        return userServiceImpl.saveUser(user);
    }

    /**
     * To delete user with id
     * @param id
     * @return
     */
    @DeleteMapping(value="/delete/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id){
        return  userServiceImpl.deleteById(id);
    }

    /**
     * To update User
     * @param user
     * @return
     */
    @PutMapping(value="/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isPresent()){
            User userFind = userOptional.get();
            userFind.setId(user.getId());
            userFind.setUsername(user.getUsername());
            userFind.setAge(user.getAge());
            userFind.setCity(user.getCity());
            return new ResponseEntity<>(userRepository.save(userFind), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }




}
