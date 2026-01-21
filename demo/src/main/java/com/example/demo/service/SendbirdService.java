package com.example.demo.service;

import com.example.demo.config.SendbirdConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SendbirdService {

    @Autowired
    private SendbirdConfig sendbirdConfig;

//    @Autowired
    private RestTemplate restTemplate;

    // Create a Sendbird user
    public String createUser(String userId, String nickname) {
        String url = sendbirdConfig.getBaseUrl() + "/users";

        // Build request body
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("user_id", userId);
        requestBody.put("nickname", nickname);

        // Build headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Api-Token", sendbirdConfig.getApiToken());

        // Build HTTP entity
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // Send POST request
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    // Send message to a specific user via Sendbird
    public String sendMessage(String channelUrl, String senderId, String message) {
        String url = sendbirdConfig.getBaseUrl() + "/group_channels/" + channelUrl + "/messages";

        // Build request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("message_type", "MESG"); // Message type (e.g., MESG = text message)
        requestBody.put("user_id", senderId);
        requestBody.put("message", message);

        // Build headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Api-Token", sendbirdConfig.getApiToken());

        // Build HTTP entity
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Send POST request
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}