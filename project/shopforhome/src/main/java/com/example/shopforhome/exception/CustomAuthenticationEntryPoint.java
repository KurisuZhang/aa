package com.example.shopforhome.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        Map<String, Object> data = new HashMap<>();
        data.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        data.put("message", "Unauthorized: Authentication token was either missing or invalid.");

        ObjectMapper objectMapper = new ObjectMapper();
        response.getOutputStream().println(objectMapper.writeValueAsString(data));
    }
}

