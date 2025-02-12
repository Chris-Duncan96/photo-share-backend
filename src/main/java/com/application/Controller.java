package com.application;
    
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
    
@RestController
public class Controller {
    Service service = new Service();

    @GetMapping("/")
    public String index() {
        return "ok";
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }

    @GetMapping("/photos/{photoId}")
    public String getPhoto(@PathVariable String photoId) {
        return service.getPhoto(photoId);
    }

    @GetMapping("/test")
    public String getService() {
        return service.getExample();
    }
}
