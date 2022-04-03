package com.ascii274.mongodb.service;

import com.ascii274.mongodb.model.User;
import com.ascii274.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Boolean saveUser(User user) {
        try {
            userRepository.save(user); // return User
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteById(Long id) {

        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }


}
