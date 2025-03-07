package com.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient
            .builder()
            .baseUrl("https://showcase.leantechniques.com")
            .defaultHeader("lt_api_key", PhotoShareAuthentication.getSecret())
            .build();
    }
}
