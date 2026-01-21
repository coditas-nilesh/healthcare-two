package com.example.demo.controller;

import com.example.demo.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Simulate login and return JWT token
    @PostMapping("/login")
    public String login(@RequestParam String username) {
        // Typically, you would also verify the password here
        return jwtTokenUtil.generateToken(username);
    }
}