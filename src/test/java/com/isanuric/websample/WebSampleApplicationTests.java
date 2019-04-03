package com.isanuric.websample;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class WebSampleApplicationTests {

    @Autowired
    protected WebTestClient webTestClient;

    @Test
    public void getUserById() {

        webTestClient
                .get().uri("/users")
                .exchange()

                // validate
                .expectStatus().isOk()
                .expectBody(String.class).consumeWith(v -> {
            System.out.println(v);
//            assertTrue(v.getResponseBody().contains("AAAA"));
        });
    }

}

