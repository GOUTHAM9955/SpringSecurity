package com.telusko.SecurityProject01.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users{
	@Id
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + "]";
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}