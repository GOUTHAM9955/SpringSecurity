package com.telusko.SecurityProject01;
// IN THIS PROJECT WE ARE GOING TO EXPLORE HOW TO STORE PASSWORDS SECURELY STORE PASSWORDS BY ENCRYPTING IT
/*
FOR THIS WE ARE GOING TO BCRYPT PASSWORD GENERATOR
	Spring boot by default supports Bcrypt encoding which we implemented in TeluskoController... check code

	For authentication, we have enabled password encoder we did it using setPasswordEncoder in SecurityConfig

	We disabled authentication for /register request in SecurityConfig
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityProject01Application.class, args);
	}

}
