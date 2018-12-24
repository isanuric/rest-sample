package com.isanuric.websample.controller;

import com.isanuric.websample.user.User;
import com.isanuric.websample.user.UserRepository;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Project: web-sample
 * @author ehsan.salmani
 */
@RestController
@RequestMapping("/web-app")
public class Logincontroller {
    
    private UserRepository userRepository;

    public Logincontroller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("welcome", "hallo and welcome!");
        return "/pub/react-login.js";
    }

    @GetMapping("/users")
    public Iterable<User> getAllUser() {
        return this.userRepository.findAll();
    }
    
    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return this.userRepository.findById(id);
    }

//    @GetMapping("/")
//    public String   () {
//        ;
//    }

}
