package com.telusko.SecurityProject01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securityFiltersChain(HttpSecurity http) throws Exception
	{
		http.csrf(customizer->customizer.disable());
		//http.formLogin(Customizer.withDefaults());
		http.authorizeHttpRequests(authorizeHttp->authorizeHttp
				.requestMatchers("add-user","login").permitAll().anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement
		(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(userDetailsService);
		//daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		daoProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return daoProvider;
		
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}
	
//	@Bean
//	public UserDetailsService userDetails()
//	{
//		UserDetails user = User.withDefaultPasswordEncoder()
//		.username("Vishal")
//		.password("telusko1")
//		.roles("USER")
//		.build();
//		
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("Rohan")
//				.password("telusko2")
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
//	}
}
