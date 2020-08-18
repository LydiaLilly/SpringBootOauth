package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("api/v1/test")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("test")
	public String inde2x() {
		return "Greetings from Spring Boot!";
	}

}