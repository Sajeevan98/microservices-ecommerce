package com.project.sajee.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final String [] freeResourcesURLs= {
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/api-docs/**",
            "/aggregate/**" // Allows requests like /aggregate/product-service/v3/api-docs
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.authorizeHttpRequests(authorize-> authorize
                        .requestMatchers(freeResourcesURLs).permitAll()
                        .anyRequest().authenticated())
                        .oauth2ResourceServer(oauth2-> oauth2.jwt(Customizer.withDefaults()))
                        .build();
    }
}
