package com.doubleciti.laitucao.controller;

import com.doubleciti.laitucao.forms.UserCreateForm;
import com.doubleciti.laitucao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
@Scope("request")
@RequestMapping(value="/")
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
//        model.put("postList", postRepository.findAll());
        return "posts/index";
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String signupGet(Map<String, Object> model) {
        model.put("form", new UserCreateForm());
        return "users/signup";
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public String signupPost(@Valid @ModelAttribute("form") UserCreateForm form,
                              BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            return "users/signup";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "users/signup";
        }
        return "redirect:/signin";
    }

    @RequestMapping(value="/signin", method = RequestMethod.GET)
    public ModelAndView siginGet(@RequestParam Optional<String> error) {
        if (error.isPresent()) {
            LOGGER.error(error.get());
        }
        return new ModelAndView("users/signin", "error", error);
    }
}
