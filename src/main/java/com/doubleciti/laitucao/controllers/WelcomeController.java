package com.doubleciti.laitucao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class WelcomeController {
    @RequestMapping(value="/welcome", method= RequestMethod.GET)
    public ModelAndView welcome(ModelAndView mv) {
        mv.addObject("message", "hello");
        mv.setViewName("welcome");
        return mv;
    }
}
