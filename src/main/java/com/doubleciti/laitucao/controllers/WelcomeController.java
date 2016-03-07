package com.doubleciti.laitucao.controllers;

import com.doubleciti.laitucao.entities.Post;
import com.doubleciti.laitucao.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value="/")
public class WelcomeController {
    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value="/welcome", method=RequestMethod.GET)
    public String welcome(Map<String, Object> model) {
        model.put("postList", postRepository.findAll());
        return "welcome";
    }

    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String create_get(Map<String, Object> model) {
        return "create";
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String create_post(@ModelAttribute Post post, BindingResult result, Map<String, Object> model) {
        Post newPost = new Post(post.getLink());
        postRepository.save(newPost);
        return "redirect:/view/" + newPost.getId();
    }

    @RequestMapping(value="/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable String id, Map<String, Object> model) {
        model.put("post", postRepository.findOne(id));
        return "view";
    }
}
