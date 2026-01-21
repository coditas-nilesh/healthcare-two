package com.example.demo.controller;

import com.example.demo.service.SendbirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sendbird")
public class SendbirdController {

    @Autowired
    private SendbirdService sendbirdService;

    // Endpoint to create a user
    @PostMapping("/create-user")
    public String createUser(@RequestParam String userId, @RequestParam String nickname) {
        return sendbirdService.createUser(userId, nickname);
    }

    // Endpoint to send a message
    @PostMapping("/send-message")
    public String sendMessage(
            @RequestParam String channelUrl,
            @RequestParam String senderId,
            @RequestParam String message) {
        return sendbirdService.sendMessage(channelUrl, senderId, message);
    }
}