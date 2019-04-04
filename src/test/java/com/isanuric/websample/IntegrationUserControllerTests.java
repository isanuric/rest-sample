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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class IntegrationUserControllerTests {

    @Autowired
    protected WebTestClient webTestClient;

    private static final int TESTUSER_1 = 0;
    private static final int TESTUSER_2 = 1;
    private static final int TESTUSER_3 = 2;
    private static final int ALLUSER_LENGTH = 11;

    @Test
    @DisplayName("Get all user")
    public void getAllUser() {
        webTestClient
                .get().uri("/user/all")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(User.class).consumeWith(v -> {
            System.out.println(v);
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
    @DisplayName("Check eight first user")
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

    @ParameterizedTest
    @CsvSource({
            "testUser10",
            "testUser11",
            "testUser12",
    })
    @DisplayName("Add three new user")
    public void addNewUser(String uid) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("uid", uid);
        webTestClient
                .post().uri("/user/create")
                .body(BodyInserters.fromFormData("name", uid))
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(User.class).consumeWith(v -> {
            assertThat(v.getResponseBody().get(0).getName().equals(uid)).isTrue();
        });
    }

}

