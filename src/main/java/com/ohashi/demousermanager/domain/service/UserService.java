package com.ohashi.demousermanager.domain.service;

import com.ohashi.demousermanager.application.web.payload.UserRequest;
import com.ohashi.demousermanager.application.web.payload.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest newUser) throws Exception;
}
