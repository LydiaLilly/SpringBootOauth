package com.example.demo.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(1000)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.requestMatchers().antMatchers("/login",
	 * "/oauth/authorize").and().authorizeRequests().anyRequest()
	 * .authenticated().and().formLogin().permitAll(); }
	 */
	
	@Override
	  public void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	        .antMatchers("/resources/**").permitAll()
	        .antMatchers("/login*").permitAll()
	        .anyRequest().authenticated()
	        .and().formLogin().loginPage("/login");
	  }

		/*
		 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
		 * Exception {
		 * auth.inMemoryAuthentication().withUser("lydia").password(passwordEncoder().
		 * encode("123456")).roles("USER"); }
		 */

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception
	 * {// @formatter:off http.cors() .and() .authorizeRequests()
	 * .antMatchers(HttpMethod.GET, "/user/info", "/api/foos/**")
	 * .hasAuthority("SCOPE_read") .antMatchers(HttpMethod.POST, "/api/foos")
	 * .hasAuthority("SCOPE_write") .anyRequest() .authenticated() .and()
	 * .oauth2ResourceServer() .jwt(); }
	 */

}
