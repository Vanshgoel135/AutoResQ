package com.autoresq.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // Authorization Header read karo
        String authHeader = request.getHeader("Authorization");

        // Agar token nahi hai to request ko aage bhej do
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // "Bearer " hata kar sirf token nikalo
        String token = authHeader.substring(7);

        // Token se email extract karo
        String email = jwtUtil.extractEmail(token);

        // Check karne ke liye console me print
        System.out.println("Logged In User: " + email);

        // Request ko aage bhej do
        filterChain.doFilter(request, response);
    }
}