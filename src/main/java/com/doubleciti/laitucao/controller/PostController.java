package com.doubleciti.laitucao.controller;

import java.util.Map;
import java.util.Optional;

import com.doubleciti.laitucao.domain.Post;
import com.doubleciti.laitucao.service.PostService;
import com.doubleciti.laitucao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/posts")
public class PostController {
    private final UserService userService;

    private final PostService postService;

    @Autowired
    public PostController(UserService userService,
                          PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public String postsGET(Map<String, Object> model) {
        return "posts/create";
    }

//    @RequestMapping(value="", method=RequestMethod.POST)
//    public String postsPost(@ModelAttribute("postForm") @Validated PostCreateForm form,
//                            BindingResult bindingResult,
//                            Authentication authentication) {
//        if (bindingResult.hasErrors()) {
//            return "posts/create";
//        }
//        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
//        Optional<User> user = userService.getUserById(currentUser.getId());
//        if (user.isPresent()) {
//            Post post = postService.create(form, user.get());
//            return "redirect:/posts/" + post.getId();
//        }
//        return "posts/create";
//    }

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
