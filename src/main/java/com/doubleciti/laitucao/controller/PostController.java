package com.doubleciti.laitucao.controller;

import com.doubleciti.laitucao.domain.CurrentUser;
import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.domain.User;
import com.doubleciti.laitucao.form.PostCreateForm;
import com.doubleciti.laitucao.service.PostService;
import com.doubleciti.laitucao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value="/posts")
public class PostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    private final UserService userService;
    private final PostService postService;

    @Autowired
    public PostController(UserService userService,
                          PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public String postsGET() {
        return "posts/create";
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public String postsPost(@Valid @ModelAttribute("form") PostCreateForm form,
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
