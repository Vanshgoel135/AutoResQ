package com.autoresq.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // Secret Key (Used for Signing JWT)
    private final SecretKey SECRET_KEY =
            Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token Validity (24 Hours)
    private static final long EXPIRATION_TIME =
            1000 * 60 * 60 * 24;

    // ==============================
    // Generate JWT Token
    // ==============================
    public String generateToken(String email, String role) {

        return Jwts.builder()
                .subject(email)                      // User Email
                .issuedAt(new Date())                // Token Created Time
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)                // Digital Signature
                .compact();                          // Convert into String Token
    }

    // ==============================
    // Extract All Claims
    // ==============================
    public Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // ==============================
    // Extract Email
    // ==============================
    public String extractEmail(String token) {

        return extractAllClaims(token).getSubject();
    }

    // ==============================
    // Check Token Expired
    // ==============================
    public boolean isTokenExpired(String token) {

        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    // ==============================
    // Validate Token
    // ==============================
    public boolean validateToken(String token) {

        try {

            return !isTokenExpired(token);

        } catch (Exception e) {

            return false;
        }
    }
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

}