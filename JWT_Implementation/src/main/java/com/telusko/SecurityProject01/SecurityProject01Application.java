package com.telusko.SecurityProject01;
//IN THIS PROJECT WE ARE GOING TO LEARN AND EXPLORE JWT(Jason Web Token) TOKEN IMPLEMENTATION FOR AUTHENTICATION AND AUTHORIZATION
/*
In this project we are implemeting JWT token based authentication for this
	We create a login page and once the user got sucessfully logged in we are going to generate and assin a JWT Token and gng frwd user can use this token to access other resources
		>> Generation fo JWT token
		>> Validation of JWT token
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityProject01Application.class, args);
	}

}
