package com.ohashi.demousermanager.domain.service.impl;

import com.ohashi.demousermanager.application.web.payload.UserRequest;
import com.ohashi.demousermanager.application.web.payload.UserResponse;
import com.ohashi.demousermanager.domain.entity.User;
import com.ohashi.demousermanager.domain.repository.UserRepository;
import com.ohashi.demousermanager.domain.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse createUser(UserRequest newUser) throws Exception {
        try {
            var existsUser = repository.getByNickname(newUser.getNickname());

            if (existsUser != null) {
                throw new Exception("User already exists in database!");
            }

            existsUser = repository.getByEmail(newUser.getEmail());

            if (existsUser != null) {
                throw new Exception("User already exists in database!");
            }

            var createdUser = repository.save(new User(newUser));

            return new UserResponse(createdUser);
        } catch (Exception err) {
            throw new Exception(err);
        }
    }
}
