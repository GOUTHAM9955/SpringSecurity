package com.telusko.SecurityProject01.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.SecurityProject01.Entity.Users;

@Repository
public interface IUserRepo extends JpaRepository<Users, String> {
	Users findByUsername(String username);
}
