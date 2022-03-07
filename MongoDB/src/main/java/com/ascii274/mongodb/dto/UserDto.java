package com.ascii274.mongodb.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Data
@Document(collection = "users")
public class UserDto {
    @Id
    @Field(name="id")
    private String id;
    @Field(name="email")
    private String email;
    @Field(name="password")
    private String password;
    @Field(name="role")
    private String role;

    public UserDto(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDto(){

    }
}
