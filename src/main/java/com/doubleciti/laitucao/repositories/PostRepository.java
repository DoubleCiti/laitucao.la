package com.doubleciti.laitucao.repositories;

import com.doubleciti.laitucao.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
