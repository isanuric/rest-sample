package com.isanuric.websample.user;

import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * ----------------------------------------------
 * (c) 2018 Copyright iC Consult GmbH
 * <p/>
 * Project: web-sample
 * @author Ehsan Salmani
 */

@Component
public class DataBaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataBaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Stream.of("user01", "user02", "user03", "user04", "user05", "user06", "user07", "user08")
                .forEach(user -> this.userRepository.save(new User(user)));
    }
}
