package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.reactive.function.client.WebClient;

/*
 * @EnableWebSecurity public class UiSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override public void configure(HttpSecurity http) throws Exception {
 * http.antMatcher("/**") .authorizeRequests() .antMatchers("/") .permitAll()
 * .anyRequest() .authenticated() .and() .oauth2Login(); }
 * 
 * 
 * }
 */