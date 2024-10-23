package com.Micro.Estudiantes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/estudiantes/**", "/h2-console/**", "/login", "/oauth2/**").permitAll() 
                .anyRequest().authenticated() 
            )
            .oauth2Login(oauth2Login -> 
                oauth2Login
                    .defaultSuccessUrl("/loginSuccess", true) 
            )
            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
            .headers(headers -> headers.frameOptions().disable());


        return http.build();
    }
}
