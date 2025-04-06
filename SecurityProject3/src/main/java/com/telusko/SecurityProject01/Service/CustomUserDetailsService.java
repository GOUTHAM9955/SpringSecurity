package com.telusko.SecurityProject01.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.SecurityProject01.Entity.Users;
import com.telusko.SecurityProject01.repo.IUserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IUserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users users = repo.findByUsername(username);
		if(users == null) {
			throw new UsernameNotFoundException("User Not Found 404");
		}
		
		return new UserPrinciple(users);
		
	}
	
}
