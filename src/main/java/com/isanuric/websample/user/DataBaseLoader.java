package com.isanuric.websample.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * ----------------------------------------------
 * (c) 2018 Copyright iC Consult GmbH
 * <p/>
 * Project: web-sample
 * @author ehsan.salmani@ic-consult.de on 23/12/2018.
 */

@Component
public class DataBaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataBaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        this.userRepository.save(new User("test01", "testlastname", "description"));

    }
}
