package com.masai.evaluation4.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SecurityConfig {

//    XSRF-TOKEN=53bc3507-a821-4dc3-a87f-e184d9490508

    @Bean public SecurityFilterChain mainSecurityConfig(HttpSecurity httpSecurity) throws Exception{


        httpSecurity.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .cors(cors ->{


                    cors.configurationSource(new CorsConfigurationSource() {

                        @Override
                        public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                            CorsConfiguration cfg= new CorsConfiguration();


                            cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
                            cfg.setAllowedMethods(Collections.singletonList("*"));
                            cfg.setAllowCredentials(true);
                            cfg.setAllowedHeaders(Collections.singletonList("*"));
                            cfg.setExposedHeaders(Arrays.asList("Authorization"));
                            return cfg;



                        }
                    });


                })
        .authorizeHttpRequests(auth ->{
            auth.requestMatchers("/users").permitAll()
                    .requestMatchers(HttpMethod.POST,"/hosts","/properties","/rooms","/users").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET,"/users","/properties","/rooms").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE,"/bookings").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST,"/users","/auth/login","bookings").hasRole("USER")
                    .requestMatchers(HttpMethod.PUT,"/bookings").hasRole("USER")
                    .requestMatchers(HttpMethod.GET,"/users","/").hasRole("USER")
                    .anyRequest().authenticated();
        }).csrf(csrf -> csrf.disable())
                .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

}
