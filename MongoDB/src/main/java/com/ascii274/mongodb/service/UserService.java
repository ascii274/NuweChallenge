package com.ascii274.mongodb.service;

import com.ascii274.mongodb.model.User;

public interface UserService {
    Boolean saveUser(User user);
    Boolean deleteById(Long id);



}
