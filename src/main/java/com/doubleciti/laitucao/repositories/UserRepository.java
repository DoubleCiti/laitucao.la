package com.doubleciti.laitucao.repositories;

import com.doubleciti.laitucao.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByEmail(String email);
}
