package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendbirdConfig {

    @Value("${sendbird.api.token}")
    private String apiToken;

    @Value("${sendbird.api.base-url}")
    private String baseUrl;

    public String getApiToken() {
        return apiToken;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}