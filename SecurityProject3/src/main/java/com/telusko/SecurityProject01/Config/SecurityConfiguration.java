package com.telusko.SecurityProject01.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.telusko.SecurityProject01.Service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	// The default implementation of UserDetailsService is it will fetch the info from application.properties and provides authentication 
	 //but we are overriding it my implementing that class
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFiltersChain(HttpSecurity http) throws Exception {
		System.out.println("filter ssssssssssssssssssssssssssssssss");
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
		
	// We use authentication provider object to fetch the user from DB, we have many authentication providers 
		//in this project we are using DaoAuthnticationProvicer to connect to DB and get credentials 
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(userDetailsService);
		// We are not implementing password encoder for now
		daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return daoProvider;
	}
	
	/*
	@Bean
	public UserDetailsService userDetailsService() {
	    UserDetails user1 = User.withUsername("admin")
	                            .password("{noop}password")  // {noop} indicates no encoding
	                            .roles("ADMIN")
	                            .build();

	    UserDetails user2 = User.withUsername("user")
	                            .password("{noop}password")
	                            .roles("USER")
	                            .build();

	    return new InMemoryUserDetailsManager(user1, user2);
	}
	*/
		
}
