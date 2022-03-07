package com.ascii274.mongodb.service;

import com.ascii274.mongodb.dto.UserDto;
import com.ascii274.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserDto saveUserDto(UserDto userDto) {
        try{
            return userRepository.save(userDto); // return UserDto
        }catch (Exception e){
            return null;
        }
    }
}
