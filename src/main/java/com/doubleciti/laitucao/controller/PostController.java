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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value="/posts")
public class PostController extends WebMvcConfigurerAdapter {
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

    @RequestMapping(value="", method=RequestMethod.GET)
    public String postsGET(Map<String, Object> model) {
        model.put("postForm", new PostCreateForm());
        return "posts/create";
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public String postsPost(@ModelAttribute("postForm") @Validated PostCreateForm form,
                            BindingResult bindingResult,
                            Authentication authentication) {
        if (bindingResult.hasErrors()) {
            LOGGER.info("error saving post={}", bindingResult.getAllErrors());
            return "posts/create";
        }
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        Optional<User> user = userService.getUserById(currentUser.getId());
        if (user.isPresent()) {
            Post post = postService.create(form, user.get());
            return "redirect:/posts/" + post.getId();
        }
        return "posts/create";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Map<String, Object> model) {
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            model.put("post", post.get());
            return "posts/view";
        }
        return "posts/view";
    }
}
