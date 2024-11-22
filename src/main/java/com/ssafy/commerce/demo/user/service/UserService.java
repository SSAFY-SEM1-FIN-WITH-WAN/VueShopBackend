package com.ssafy.commerce.demo.user.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	
	public boolean updateDatebase(User user);
	
	public User uploadFirebase(MultipartFile file, User user) throws IOException;
	
	public User resetDatabase(User user);
	
	public void deleteFirebase(String fileName);
}
