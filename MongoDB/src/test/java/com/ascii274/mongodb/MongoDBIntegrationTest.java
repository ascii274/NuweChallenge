package com.ascii274.mongodb;

import com.ascii274.mongodb.dto.UserDto;
import com.ascii274.mongodb.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *  Functional
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class MongoDBIntegrationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads(){}

    @Test
    public void givenUserObject(){
        UserDto userDto = new UserDto();
        userDto.setId("621c09a9cf6edf58b3dad0c7");
        userDto.setEmail("test@mail.com");
        userDto.setPassword("123test");
        userDto.setRole("User");
        userRepository.save(userDto);
        assertThat(userRepository.findAll().size()).isGreaterThan(0);
        userRepository.delete(userDto);

    }
}
