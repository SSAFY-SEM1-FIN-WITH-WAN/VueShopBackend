package com.ssafy.commerce.demo.user.dao;

import java.util.List;

import com.ssafy.commerce.demo.user.dto.LoginRequest;
import com.ssafy.commerce.demo.user.dto.PasswordFinder;
import com.ssafy.commerce.demo.user.dto.User;

public interface UserDao {
	
	public List<User> selectAll();
	
	public User selectOne(String accountId);
	
	public int insertUser(User user);
	
	public int updateUser(User user);
	
	public User validateUser(LoginRequest loginRequest);
	
	public String getPasswordHintByNickname(PasswordFinder finder);
}
