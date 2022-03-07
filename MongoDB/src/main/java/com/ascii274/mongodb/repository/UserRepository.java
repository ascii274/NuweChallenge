package com.ascii274.mongodb.repository;

import com.ascii274.mongodb.dto.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserDto,Integer> {
    public UserDto findByEmail(String email);
//    public List<UserDto> findByEmail(String email);
}
