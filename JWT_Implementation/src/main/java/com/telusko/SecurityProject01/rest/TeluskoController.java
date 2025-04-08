package com.telusko.SecurityProject01.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SecurityProject01.entity.Users;
import com.telusko.SecurityProject01.service.JwtTokenService;
import com.telusko.SecurityProject01.service.UserService;

@RestController
public class TeluskoController 
{
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenService jwtService;
	
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder(12);
	
	@PostMapping("/add-user")
	public Users registerNewUser(@RequestBody Users user)
	{
		String encoded=bcrypt.encode(user.getPassword());
		user.setPassword(encoded);
		return service.register(user);
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody Users user)
	{
		// To authenticate the user
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));

		//If it is sucessfully authenticated
		if(authentication.isAuthenticated())
		{
			String jwt= jwtService.generateToken(user.getName());
			System.out.println(jwt);
			return jwt;
		}
		else
			return "Invalid credentials";
	}
	

	@GetMapping("/get-courseinfo")
	public String getCourseInfo()
	{
		return "Telusko launched DevOps with AWS course from scratch ";
	}
	
}
