package com.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhotoShareControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webTestClient;

    private static final String albumOne = "[{\"photoId\":1,\"url\":\"https://showcase.leantechniques.com/image/photo-10.jpg\",\"albumId\":1,\"title\":\"Work From Anywhere\"}]";
    private static final String photoThree = "{\"photoId\":3,\"url\":\"https://showcase.leantechniques.com/image/scott-1.jpg\",\"albumId\":2,\"title\":\"Scott Presenting at LT Retreat 2024\"}";

    @Test
    public void testGetAlbum() {
        String albumId = "1";

        webTestClient.get()
                .uri("/albums/{albumId}", albumId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo(albumOne);
    }

    @Test
    public void testGetPhoto() {
        String photoId = "3";

        webTestClient.get()
                .uri("/photos/{photoId}", photoId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo(photoThree);
    }
}
