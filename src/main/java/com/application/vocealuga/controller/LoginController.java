package com.application.vocealuga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class LoginController extends BaseController {
    @GetMapping("/login")
    public String login(Model model) {
        return "login.html";
    }
}
