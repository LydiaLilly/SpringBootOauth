package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.resource.UserProfile;

@Controller
public class RestResource 
{
	@RequestMapping("/user")
	public ResponseEntity<UserProfile> profile() 
	{
		//Build some dummy data to return for testing
		
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		String username = user.getName();
		
		//String email = user.getUsername() + "@howtodoinjava.com";

		UserProfile profile = new UserProfile();
		profile.setName(username);
		//profile.setEmail(email);

		return ResponseEntity.ok(profile);
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public ModelAndView method() {
	    return new ModelAndView("redirect:" + "https://sso.login.run-np.homedepot.com/oauth/authorize");
	}
}