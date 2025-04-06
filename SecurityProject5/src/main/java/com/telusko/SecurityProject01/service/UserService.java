package com.telusko.SecurityProject01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.SecurityProject01.entity.Users;
import com.telusko.SecurityProject01.repo.IUserRepo;

@Service
public class UserService 
{
	@Autowired
	private IUserRepo repo;
	
	public Users register(Users user)
	{
		return repo.save(user);
	}
}
