package com.telusko.SecurityProject01;
// IN THIS PROJECT WE ARE NOT USING THE SECURITY FEATURES PROVIDED BY SPRING INSTEAD WE ARE OVVERRIDING AND PROVIDING OUR OWN CONFIGURATIONS

//STEPS IMPLEMENTED
/*
 * >> Using SecurityConfigurationn class we are trying to override the existing spring security provided by spring for which we are using
 * 		1) SecurityFilterChain >> to enable / disable security features
 * 		2) AuthenticationProvider >> for authentication purpose
 * 			In AuthenticationProider we are using CustomUserDetailsService to pass credentials
 * 
 * >> We create a User class for storing username and password
 * 	  We had IUserRepo to find user by username
 * 
 * >> We created a service CustomUserDetailsService which return UserDetails object for  AuthenticationProider 
 * 		We created UserPrincple class to create UserDetails object based on the user object returned by DataBase
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityProject01Application.class, args);
	}

}
