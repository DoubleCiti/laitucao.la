package com.doubleciti.laitucao.service;

import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.form.PostCreateForm;
import com.doubleciti.laitucao.repository.PostRepository;
import com.doubleciti.laitucao.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
    public Optional<Post> getPostById(long id) {
        return Optional.ofNullable(postRepository.findOne(id));
    }

    @Override
    public Collection<Post> getAllPostsByUserId(long userId) {
        User user = userRepository.findOne(userId);
        return postRepository.findAll();
    }

    @Override
    public Post create(PostCreateForm form, User user) {
//
        Post post = new Post(form.getLink());
        post.setUser(user);
        LOGGER.info("save post={}", form.getLink());
        return postRepository.save(post);
    }

    @Override
    public Collection<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
