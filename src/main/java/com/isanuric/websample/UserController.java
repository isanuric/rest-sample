package com.isanuric.websample;

import com.isanuric.websample.user.User;
import com.isanuric.websample.user.UserRepository;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Project: web-sample
 * @author Ehsan Salmani
 */
@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public ResponseEntity<User> addUser(@Valid @RequestBody String user)
            throws MalformedURLException, URISyntaxException {
        User newUser = this.userRepository.save(new User(user));
        return ResponseEntity.created(new URI("/user/" + newUser.getId()))
                .body(newUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        this.userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
