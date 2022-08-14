package com.ohashi.demousermanager.application.web.controller;

import com.ohashi.demousermanager.application.web.payload.UserRequest;
import com.ohashi.demousermanager.application.web.payload.UserResponse;
import com.ohashi.demousermanager.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest user,
                                               UriComponentsBuilder uriComponentsBuilder) throws Exception {
        var createdUser = this.service.createUser(user);

        var uri = uriComponentsBuilder.path("/user").buildAndExpand(createdUser.getEmail()).toUri();

        return ResponseEntity.created(uri).body(createdUser);
    }
}
