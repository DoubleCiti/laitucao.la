package com.doubleciti.laitucao.repository;

import com.doubleciti.laitucao.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostRepository extends JpaRepository<Post, Long> {
    Collection<Post> findAllByUserId(Long UserId);
}
