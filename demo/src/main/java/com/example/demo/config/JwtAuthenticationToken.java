package com.example.demo.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String principal; // The authenticated user (username or ID)
    private final String token;     // The JWT token (optional)

    public JwtAuthenticationToken(String principal, String token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.token = token;
        setAuthenticated(true); // Marks the token as authenticated
    }

    @Override
    public Object getCredentials() {
        return token; // JWT token as credentials
    }

    @Override
    public Object getPrincipal() {
        return principal; // Username or UserDetails object
    }
}