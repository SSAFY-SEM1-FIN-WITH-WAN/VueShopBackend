package com.ssafy.commerce.demo.user.service;

import java.util.List;

import com.ssafy.commerce.demo.user.dto.Fortune;
import com.ssafy.commerce.demo.user.dto.LoginRequest;
import com.ssafy.commerce.demo.user.dto.PasswordFinder;
import com.ssafy.commerce.demo.user.dto.User;

public interface UserService {

	public List<User> getUserList();
	
	public User getUser(String accountId);
	
	public boolean signup(User user);
	
	public boolean modifyUser(User user);
	
	public String login(LoginRequest loginRequest);

	public String getPasswordHint(PasswordFinder finder);
	
	public Fortune getFortune(String accountId);
}
