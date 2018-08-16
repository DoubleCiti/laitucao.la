package com.doubleciti.laitucao.controller;

import java.util.Map;
import java.util.Optional;

import com.doubleciti.laitucao.form.UserCreateForm;
import com.doubleciti.laitucao.form.UserCreateFormValidator;
import com.doubleciti.laitucao.form.UserSigninForm;
import com.doubleciti.laitucao.service.PostService;
import com.doubleciti.laitucao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
@RequestMapping(value="/")
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private final UserService userService;

    private final PostService postService;

    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public HomeController(UserService userService,
                          PostService postService,
                          UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.postService = postService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("userCreateForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("postList", postService.getAllPosts());
        return "posts/index";
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String signupGet(Map<String, Object> model) {
        model.put("userCreateForm", new UserCreateForm());
        return "users/signup";
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("userCreateForm") @Validated UserCreateForm form,
                             BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            return "users/signup";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email", "Email already exists");
            return "users/signup";
        }
        return "redirect:/signin";
    }

    @RequestMapping(value="/signin", method = RequestMethod.GET)
    public ModelAndView siginGet(@RequestParam Optional<String> error) {
        if (error.isPresent()) {
            ModelAndView model = new ModelAndView("users/signin");
            model.addObject("error", error);
            model.addObject("userSignForm", new UserSigninForm());
        }
        return new ModelAndView("users/signin", "userSignForm", new UserSigninForm());
    }
}
