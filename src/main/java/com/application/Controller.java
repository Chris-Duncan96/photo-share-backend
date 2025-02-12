package com.application;
    
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
    
@RestController
public class Controller {
    Service service = new Service();

    @GetMapping("/health")
    public String health() {
        return "ok";
    }

    @GetMapping("/photos/{photoId}")
    public String getPhoto(String photoId) {
        return service.getPhoto(photoId);
    }
}
