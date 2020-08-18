package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/hello-auth")
	public String hello(@AuthenticationPrincipal OidcUser user) {
	    return "Hello, " + user.getFullName();
	}
	
	/*
	 * @GetMapping("/") public String index(Model model,
	 * 
	 * @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
	 * 
	 * @AuthenticationPrincipal OAuth2User oauth2User) {
	 * model.addAttribute("userName", oauth2User.getName());
	 * model.addAttribute("clientName",
	 * authorizedClient.getClientRegistration().getClientName());
	 * model.addAttribute("userAttributes", oauth2User.getAttributes()); return
	 * "index"; }
	 */
}