package com.telusko.SecurityProject01;

// IN THIS PROJECT WE ARE GOING TO EXPLORE MORE ON SPRING SECURITY

// CSRF-Tokens
//
/* 
 *  By default spring security implements CSRF(Cross sight request forgery 
 *  	In our project if we added basic authentication details in our request and submit a get request we can access the data but for post or any other request
 *  	which can manipulate the data we will get 401 due to CSRF
 *  
 *  	This is because the session id will be stored in cookies and some other external applications can access our cookies and get this sessionId 
 *  
 *  	Every time we submit a request a CSRF token will get generated and we have to pass it for POST/PUT/DELETE requests for authentication 
 *  	but it's isn't needed for GET
 *  
 *  	We implemented a get request to view csrf-token... check implementation 
 *  	 we can add that header and token from CSRF token and add it to our post header request and submit the request	
 */		

// State-ful vs State-less
/*
 * State-ful can recognize client information from the server.
 * State-less: Every request will be a new request
 * 
 * Default configuration of spring security is state-ful
 * 	We created a @Configuration class to disturb this predefined configuration of spring security.... check this CLASS
 * 	
 * 	
 */
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityProject01Application.class, args);
	}

}
