package com.masaischool.swiggy3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean public SecurityFilterChain mainSecurityConfig(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests(auth ->{
            auth.requestMatchers("/customersP","/deliveryPartner","/restaurant","/order").permitAll().anyRequest().authenticated();
        }).csrf(csr->csr.disable())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

}
