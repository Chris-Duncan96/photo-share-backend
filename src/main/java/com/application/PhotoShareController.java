package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PhotoShareController {

    @Autowired
    PhotoShareService service = new PhotoShareService();

    @GetMapping("/")
    public String index() {
        return "ok";
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }

    @GetMapping("/albums")
    public Mono<String> getAlbums() {
        return service.getAlbums();
    }

    @GetMapping("/albums/{albumId}")
    public Mono<String> getAlbum(@PathVariable String albumId) {
        return service.getAlbum(albumId);
    }

    @GetMapping("/photos/{photoId}")
    public Mono<String> getPhoto(@PathVariable String photoId) {
        return service.getPhoto(photoId);
    }
}
