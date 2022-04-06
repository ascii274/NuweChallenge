package com.ascii274.mongodb.repository;

import com.ascii274.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {
    List<User> findByUsername(String username);

}
