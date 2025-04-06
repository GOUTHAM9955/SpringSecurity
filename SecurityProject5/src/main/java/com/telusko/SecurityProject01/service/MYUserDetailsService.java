package com.telusko.SecurityProject01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.SecurityProject01.entity.Users;
import com.telusko.SecurityProject01.repo.IUserRepo;

@Service
public class MYUserDetailsService implements UserDetailsService
{
	@Autowired
	private IUserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users users = repo.findByName(userName);
		if(users==null)
		{
			throw new UsernameNotFoundException("user not found 404");
		}
		return new UserPrincipal(users);
	}

}
