package com.doubleciti.laitucao.service;

import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.model.PostModel;
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
import java.util.List;
import java.util.stream.Collectors;

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
    public PostModel getPostById(long id) {
        return new PostModel(postRepository.findOne(id));
    }

    @Override
    public Collection<Post> getAllPostsByUserId(long userId) {
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public Post create(PostModel model, User user) {
        Post post = new Post(model.getLink());
        post.setTitle(model.getTitle());
        post.setUser(user);
        Timestamp now = new Timestamp(new Date().getTime());
        post.setCreatedAt(now);
        post.setUpdatedAt(now);
        return postRepository.save(post);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return postRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "createdAt")))
                .stream()
                .map(PostModel::new)
                .collect(Collectors.toList());
    }
}
