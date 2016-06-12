package com.doubleciti.laitucao.service;

import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.forms.PostCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface PostService {
    Optional<Post> getPostById(long id);

    Collection<Post> getAllPostsByUserId(long userId);

    Post create(PostCreateForm form, User user);

    Collection<Post> getAllPosts();
}
