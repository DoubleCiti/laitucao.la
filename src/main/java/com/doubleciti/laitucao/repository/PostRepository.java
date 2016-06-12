package com.doubleciti.laitucao.repository;

import com.doubleciti.laitucao.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
