package com.isanuric.websample;


import static org.assertj.core.api.Assertions.assertThat;

import com.isanuric.websample.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class WebSampleApplicationTests {

    private static final int TESTUSER_1 = 0;
    private static final int TESTUSER_2 = 1;
    private static final int TESTUSER_3 = 2;
    private static final int ALLUSER_LENGTH = 8;
    @Autowired
    protected WebTestClient webTestClient;

    @Test
    public void getAllUser() {
        webTestClient
                .get().uri("/users")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(User.class).consumeWith(v -> {
            assertThat(v.getResponseBody().size() == ALLUSER_LENGTH).isTrue();
            assertThat(v.getResponseBody().get(TESTUSER_1).getId() == 1).isTrue();
            assertThat(v.getResponseBody().get(TESTUSER_2).getId() == 2).isTrue();
            assertThat(v.getResponseBody().get(TESTUSER_3).getId() == 3).isTrue();
            assertThat(v.getResponseBody().get(TESTUSER_1).getName().equals("user01")).isTrue();
            assertThat(v.getResponseBody().get(TESTUSER_2).getName().equals("user02")).isTrue();
            assertThat(v.getResponseBody().get(TESTUSER_3).getName().equals("user03")).isTrue();

        });
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
    })
    @DisplayName("check all eight test user")
    public void getUserById(int uid) {
        webTestClient
                .get().uri("/user/" + uid)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(User.class).consumeWith(v -> {
            assertThat(v.getResponseBody().get(0).getId() == uid).isTrue();
        });
    }

}

