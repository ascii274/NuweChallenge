package com.ascii274.mongodb.repository;

import com.ascii274.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username); // functional

}
