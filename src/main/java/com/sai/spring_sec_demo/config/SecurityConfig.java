package com.sai.spring_sec_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*
         * Iterative aproach --> (but we prefer lambda apprach only)
         * Customizer<CsrfConfigurer<HttpSecurity>> custCsrf =new
         * Customizer<CsrfConfigurer<HttpSecurity>>() {
         * public void customize(CsrfConfigurer<HttpSecurity> configurer) {
         * configurer.disable();
         * }
         * };
         * http.csrf(custCsrf);
         * 
         * Customizer<AuthorizerHttpRequestsConfigure<HttpSecurity>>
         * 
         * http.AuthorizeHttpRequestsConfigure;
         * 
         */
        /*
         * 
         * //disable the csrf token
         * http.csrf(customizer -> customizer.disable());
         * 
         * //we are enabling the security for the requests, for every request we are
         * saying authenticated
         * http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
         * 
         * http.formLogin(Customizer.withDefaults()); // we don't need form login when
         * you have stateless requests
         * http.httpBasic(Customizer.withDefaults()); //getting form for the request
         * 
         * http.sessionManagement(session ->
         * session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
         * // after this every time we load the request we get the new Session ( because
         * we made that as stateless)
         */

        // we are using the builder pattern
        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
        // here we got the hold on the object of the Http Security and we are simply
        // saying build

    }

    /*
     * --> This UsrDetailsClass work with static values
     * 
     * @Bean
     * public UserDetailsService userDetailsService() {
     * UserDetails user=User
     * .withDefaultPasswordEncoder() //we are saying that i don't want to go for any
     * encoder, That's why it was depricated
     * .username("Nithin")
     * .password("n@123")
     * .roles("USER")
     * .build();
     * UserDetails admin=User
     * .withDefaultPasswordEncoder() //we are saying that i don't want to go for any
     * encoder, That's why it was depricated
     * .username("admin")
     * .password("admin@789")
     * .roles("ADMIN")
     * .build();
     * return new InMemoryUserDetailsManager(user,admin);
     * }
     * 
     */

}
