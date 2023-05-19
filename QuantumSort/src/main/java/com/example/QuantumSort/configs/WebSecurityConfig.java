package com.example.QuantumSort.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


@Autowired
private RealtorDetailServiceImpl realtorDetailServiceImpl;


     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

    @Bean
    protected SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

        http
                .cors().disable()
                .csrf().disable()
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/signUp").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/listings/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/listings/show", true)
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(realtorDetailServiceImpl)
                .passwordEncoder(passwordEncoder());

        return http.build();
    }


}
