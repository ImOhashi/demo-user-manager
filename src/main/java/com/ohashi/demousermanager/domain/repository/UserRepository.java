package com.ohashi.demousermanager.domain.repository;

import com.ohashi.demousermanager.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    User getByNickname(String nickname);
}
