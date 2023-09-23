package com.masaischool.swiggy3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean public SecurityFilterChain mainSecurityConfig(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests(auth ->{
            auth.requestMatchers("/restaurant").permitAll()
                    .requestMatchers(HttpMethod.POST,"/deliveryPartner","/customersP").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET,"/customers").hasAnyRole("ADMIN","USER")
                    .requestMatchers(HttpMethod.POST,"/orders").hasAnyRole("ADMIN","USER")
                    .anyRequest().authenticated();
        }).csrf(csr->csr.disable())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

}
