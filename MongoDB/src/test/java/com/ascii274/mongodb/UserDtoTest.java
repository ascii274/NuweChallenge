package com.ascii274.mongodb;

import com.ascii274.mongodb.config.MongoConfig;
import com.ascii274.mongodb.dto.UserDto;
import com.ascii274.mongodb.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ## NON FUNCTIONAL ON DEVELOP
 */

@SpringBootTest
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@EnableMongoRepositories(basePackages = "com.ascii274.mongodb")
@ContextConfiguration(classes = { MongoConfig.class })
public class UserDtoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUserDto(){
        UserDto userDto = new UserDto("test@mail.com","pwduserdtotest","User");
        entityManager.persist(userDto);
        entityManager.flush();
        UserDto found = userRepository.findByEmail(userDto.getEmail());
        assertThat(found.getEmail())
                .isEqualTo(userDto.getEmail());

    }

}
