package com.example.demo.cofig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	    private CsrfTokenRepository csrfTokenRepository;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
			// @formatter:off
			/*
			 * http .authorizeRequests(a -> a .antMatchers("/", "/login",
			 * "/error","login/oauth2", "/webjars/**", "/api/v1/test").permitAll()
			 * .anyRequest().authenticated() ) .exceptionHandling(e -> e
			 * .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
			 * ) .csrf(c -> c
			 * .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
			 * .oauth2Login();
			 */
	        // @formatter:on
		 
		  http
          //Session management
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and()
		  .antMatcher("/**").authorizeRequests()
          .antMatchers("/", "/login**", "/api/v1/test", "/hello", "user", "/redirect	").permitAll()
          .anyRequest().authenticated()
          .and()
          .oauth2Login()
          .and()
          .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
          .csrf()
          .csrfTokenRepository(csrfTokenRepository);
	    }
	 
	 @Bean
	 public CsrfTokenRepository csrfTokenRepository() {
		    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		    repository.setHeaderName("X-XSRF-TOKEN");
		    return repository;
		}
	 
	 @Bean
	 CorsConfigurationSource corsConfigurationSource() {
	     CorsConfiguration configuration = new CorsConfiguration();
	     configuration.setAllowedOrigins(Arrays.asList("*"));
	     configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	     configuration.setAllowedHeaders(Arrays.asList("*"));
	     configuration.setAllowCredentials(true);
	     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     source.registerCorsConfiguration("/**", configuration);
	     return source;
	 }
	 

		/*
		 * @Bean public
		 * OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest>
		 * accessTokenResponseClient(){ DefaultAuthorizationCodeTokenResponseClient
		 * accessTokenResponseClient = new
		 * DefaultAuthorizationCodeTokenResponseClient();
		 * accessTokenResponseClient.setRequestEntityConverter(new
		 * CustomRequestEntityConverter());
		 * 
		 * OAuth2AccessTokenResponseHttpMessageConverter
		 * tokenResponseHttpMessageConverter = new
		 * OAuth2AccessTokenResponseHttpMessageConverter();
		 * tokenResponseHttpMessageConverter.setTokenResponseConverter(new
		 * CustomTokenResponseConverter()); RestTemplate restTemplate = new
		 * RestTemplate(Arrays.asList( new FormHttpMessageConverter(),
		 * tokenResponseHttpMessageConverter)); restTemplate.setErrorHandler(new
		 * OAuth2ErrorResponseErrorHandler());
		 * 
		 * accessTokenResponseClient.setRestOperations(restTemplate); return
		 * accessTokenResponseClient; }
		 */
}
