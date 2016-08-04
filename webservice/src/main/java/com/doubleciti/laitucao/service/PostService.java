package com.doubleciti.laitucao.service;

import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.form.PostCreateForm;

import java.util.Collection;

public interface PostService {
    Post getPostById(long id);

    Collection<Post> getAllPostsByUserId(long userId);

    Post create(PostCreateForm form, User user);

    Collection<Post> getAllPosts();
}
