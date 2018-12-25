package com.isanuric.websample.controller;

import com.isanuric.websample.user.User;
import com.isanuric.websample.user.UserRepository;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody String user) throws MalformedURLException, URISyntaxException {
        User newUser = this.userRepository.save(new User(user));
        return ResponseEntity.created(new URI("/web-app/user/" + newUser.getId()))
                .body(newUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/")
//    public String   () {
//        ;
//    }

}
