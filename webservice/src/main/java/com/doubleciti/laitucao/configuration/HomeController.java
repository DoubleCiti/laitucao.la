package com.doubleciti.laitucao.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/api-docs")
    public String index() {
        System.out.println("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
}
