package com.ohashi.demousermanager.application.web.payload;

import com.ohashi.demousermanager.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    public UserResponse(User user) {
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
    }

    private String name;

    private String nickname;

    private String email;
}
