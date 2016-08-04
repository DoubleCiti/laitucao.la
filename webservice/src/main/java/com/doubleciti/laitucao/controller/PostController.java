package com.doubleciti.laitucao.controller;

import com.doubleciti.laitucao.domain.CurrentUser;
import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.form.PostCreateForm;
import com.doubleciti.laitucao.form.PostCreateFormValidator;
import com.doubleciti.laitucao.service.PostService;
import com.doubleciti.laitucao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value="/posts")
public class PostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    private final UserService userService;
    private final PostService postService;

    private final PostCreateFormValidator postCreateFormValidator;

    @Autowired
    public PostController(UserService userService,
                          PostService postService,
                          PostCreateFormValidator postCreateFormValidator) {
        this.userService = userService;
        this.postService = postService;
        this.postCreateFormValidator = postCreateFormValidator;
    }

    @InitBinder("postCreateForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(postCreateFormValidator);
    }

//    @RequestMapping(value="", method=RequestMethod.GET)
//    public String postsGET(Map<String, Object> model) {
//        model.put("postForm", new PostCreateForm());
//        return "posts/create";
//    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Collection<?> listPosts() {
        return postService.getAllPosts();
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    ResponseEntity<?> createPost(@ModelAttribute("postForm") @Validated PostCreateForm form,
                                BindingResult bindingResult,
                                Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        Optional<User> user = userService.getUserById(currentUser.getId());
        if (user.isPresent()) {
            postService.create(form, user.get());
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    Post getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }
}
