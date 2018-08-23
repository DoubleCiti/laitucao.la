package com.doubleciti.laitucao.controller;

import javax.validation.Valid;

import com.doubleciti.laitucao.model.SignInInfo;
import com.doubleciti.laitucao.model.SignUpInfo;
import com.doubleciti.laitucao.model.UserInfo;
import com.doubleciti.laitucao.service.PostService;
import com.doubleciti.laitucao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class HomeController {
    private final UserService userService;

    private final PostService postService;

    @Autowired
    public HomeController(final UserService userService,
                          final PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public UserInfo signUp(@Valid @RequestBody final SignUpInfo info) {
        log.debug("Trying to create user with {}", info);

        return userService.create(info);
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public UserInfo signIn(@Valid @RequestBody final SignInInfo info) {
        log.debug("Trying to sign in user with {}", info);

        return userService.signIn(info);
    }
}
