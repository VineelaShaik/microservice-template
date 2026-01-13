package com.company.platform.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtTokenValidator {

    
    private static final String SECRET =
            "this-is-a-very-secure-secret-key-for-jwt-validation-only-123456";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public Claims validateAndGetClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
