package com.doubleciti.laitucao.controller;

import com.doubleciti.laitucao.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value="/posts")
public class PostController {
    @RequestMapping(value="", method=RequestMethod.GET)
    public String create_get(Map<String, Object> model) {
        return "posts/create";
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String create_post(@ModelAttribute Post post,
                              BindingResult result,
                              Map<String, Object> model) {
        Post newPost = new Post(post.getLink());
//        postRepository.save(newPost);
        return "redirect:/view/" + newPost.getId();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String view(@PathVariable String id, Map<String, Object> model) {
//        model.put("post", postRepository.findOne(id));
        return "posts/view";
    }
}
