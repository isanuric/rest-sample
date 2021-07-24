package com.isanuric.websample.flower;


import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.isanuric.websample.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class FlowerControllerTest extends TestConfig {

    @Autowired
    FlowerService flowerService;

    private WireMockServer wireMockServer = new WireMockServer();

    @BeforeEach
    public void setUp() {
        wireMockServer.start();
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void getFlowerString() {
        stubFor(get(urlPathMatching("/flower/string-one"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Roses")));

        assertEquals("Roses", flowerService.getFlowerString());
    }

//    @Test
//    void getFlower() {
//        stubFor(get(urlPathMatching("/flower/string-one"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "text")
//                        .withBody("Roses")));
//
//        assertEquals("Rose", flowerService.getFlowerString());
//    }

}
