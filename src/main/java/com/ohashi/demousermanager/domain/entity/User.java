package com.ohashi.demousermanager.domain.entity;

import com.ohashi.demousermanager.application.web.payload.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(UserRequest newUser) {
        this._id = UUID.randomUUID();
        this.name = newUser.getName();
        this.nickname = newUser.getNickname();
        this.password = newUser.getPassword();
        this.email = newUser.getEmail();
    }

    @Id
    private UUID _id;

    private String name;

    private String nickname;

    private String password;

    private String email;
}
