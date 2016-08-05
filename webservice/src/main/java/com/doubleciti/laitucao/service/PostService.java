package com.doubleciti.laitucao.service;

import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.model.PostModel;

import java.util.Collection;
import java.util.List;

public interface PostService {
    PostModel getPostById(long id);

    Collection<Post> getAllPostsByUserId(long userId);

    Post create(PostModel form, User user);

    List<PostModel> getAllPosts();
}
