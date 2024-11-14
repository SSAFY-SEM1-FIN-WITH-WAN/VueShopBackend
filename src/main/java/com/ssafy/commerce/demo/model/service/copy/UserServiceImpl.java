package com.ssafy.commerce.demo.model.service.copy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.commerce.demo.model.dao.UserDao;
import com.ssafy.commerce.demo.model.dto.User;


@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User login(String id, String password) {
		Map<String, String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		User tmp = userDao.selectOne(info);
		return tmp;
	}

}
