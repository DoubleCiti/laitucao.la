package com.doubleciti.laitucao.controllers;

import com.doubleciti.laitucao.entities.User;
import com.doubleciti.laitucao.repositories.PostRepository;
import com.doubleciti.laitucao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value="/")
public class HomeController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("postList", postRepository.findAll());
        return "posts/index";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register_get(Map<String, Object> model) {
        return "users/register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register_post(@ModelAttribute User user) {
        userRepository.save(new User(user.getEmail(), user.getUsername(), user.getPassword()));
        return "redirect:/";
    }
}
