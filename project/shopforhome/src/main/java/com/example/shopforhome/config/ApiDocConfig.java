package com.example.shopforhome.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(    info = @Info(title = "My API", version = "v1"),
    servers = {
        @Server(url = "http://localhost:8080", description = "Production Server"),
        @Server(url = "https://probable-parakeet-6rv5w9r5w943wx5-8080.app.github.dev/", description = "Staging Server")
    })
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class ApiDocConfig {
}