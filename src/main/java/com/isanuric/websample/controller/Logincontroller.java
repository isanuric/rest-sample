package com.isanuric.websample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Project: web-sample
 * @author ehsan.salmani
 */
@Controller
public class Logincontroller {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("welcome", "hallo and welcome!");
        return "/pub/react-login.js";
    }

}
