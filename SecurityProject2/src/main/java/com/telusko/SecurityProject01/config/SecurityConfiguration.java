package com.telusko.SecurityProject01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFiltersChain(HttpSecurity http) throws Exception {
		
		// To disable CSRF token 
		http.csrf(customizer->customizer.disable());
		// To enable login form 
		http.formLogin(Customizer.withDefaults());
		// To access it from any browser or tools like postman 
		http.httpBasic(Customizer.withDefaults());
		// All the requests will be considered as a new request 
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		// If you didn't configure any of the above and just return http.build() to Spring, it won't have any of these security configurations not even default spring security 
		return http.build();
		 
	}
	
	// By default the credentials for login will be fetched from the application properties and will the help of UserDetailsService interface and
		// we will override that 
	@Bean
	public UserDetailsService userDetails() {
	UserDetails user = User.withDefaultPasswordEncoder().username("GK").password("gkakani").roles("User").build();
	UserDetails admin = User.withDefaultPasswordEncoder().username("GK123").password("gkakani123").roles("Admin").build();
	return new InMemoryUserDetailsManager(user, admin);
 
	}
}
