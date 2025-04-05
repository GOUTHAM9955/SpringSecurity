package com.telusko.SecurityProject01.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.SecurityProject01.entity.Users;

public interface IUserRepo extends JpaRepository<Users, String> 
{
	Users findByName(String userName);
}
