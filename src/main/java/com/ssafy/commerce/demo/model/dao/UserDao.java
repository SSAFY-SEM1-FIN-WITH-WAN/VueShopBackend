package com.ssafy.commerce.demo.model.dao;

import com.ssafy.commerce.demo.model.dto.User;
import java.util.List;
import java.util.Map;

public interface UserDao {
	public List<User> selectAll();

	public void insertUser(User user);

	public User selectOne(Map<String, String> info);
}