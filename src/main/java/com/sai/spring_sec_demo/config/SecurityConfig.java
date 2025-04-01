package com.sai.spring_sec_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
     * By default spring will define this object for us if we are not defining it,
     * entire spring security behind the scene works with this
     * spring security filter chain for the filters in between, but now we are
     * changing it
     * 
     * bY default this below method uses HttopSecurity to do that
     */
    @Bean
    public SecurityFilterChain securityFilterCahin(HttpSecurity http) throws Exception {

        return http.build();
    }
}
