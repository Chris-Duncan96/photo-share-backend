package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PhotoShareService {

    @Autowired
    private WebClient webClient;

    public Mono<String> getAlbum(String albumNumber) {
        String endpoint = "/albums/" + albumNumber;
        return webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getAlbums() {
        String endpoint = "/albums";
        return webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getPhoto(String photoId) {
        String endpoint = "/photos/" + photoId;
        return webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class);
    }
}
