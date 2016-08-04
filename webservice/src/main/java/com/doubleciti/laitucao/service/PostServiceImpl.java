package com.doubleciti.laitucao.service;

import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.form.PostCreateForm;
import com.doubleciti.laitucao.repository.PostRepository;
import com.doubleciti.laitucao.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Service
public class PostServiceImpl implements PostService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;
    private final UserRepository userRepository;
//    private final Authentication authentication;

    @Autowired
    public PostServiceImpl(UserRepository userRepository,
                           PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
//        this.authentication = authentication;
    }

    @Override
    public Post getPostById(long id) {
        return postRepository.findOne(id);
    }

    @Override
    public Collection<Post> getAllPostsByUserId(long userId) {
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public Post create(PostCreateForm form, User user) {
        Post post = new Post(form.getLink());
        post.setTitle(form.getTitle());
        post.setUser(user);
        Timestamp now = new Timestamp(new Date().getTime());
        post.setCreatedAt(now);
        post.setUpdatedAt(now);
        return postRepository.save(post);
    }

    @Override
    public Collection<Post> getAllPosts() {
        return postRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "createdAt")));
    }
}
