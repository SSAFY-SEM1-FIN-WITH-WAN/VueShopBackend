package com.ssafy.commerce.demo.user.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.commerce.demo.jwt.JwtUtil;
import com.ssafy.commerce.demo.user.dao.FortuneDao;
import com.ssafy.commerce.demo.user.dao.UserDao;
import com.ssafy.commerce.demo.user.dao.ZodiacDao;
import com.ssafy.commerce.demo.user.dto.Fortune;
import com.ssafy.commerce.demo.user.dto.LoginRequest;
import com.ssafy.commerce.demo.user.dto.PasswordFinder;
import com.ssafy.commerce.demo.user.dto.User;
import com.ssafy.commerce.demo.user.dto.Zodiac;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	private final ZodiacDao zodiacDao;
	private final FortuneDao fortuneDao;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserDao userDao, ZodiacDao zodiacDao, FortuneDao fortuneDao, JwtUtil jwtUtil) {
        this.userDao = userDao;
        this.zodiacDao = zodiacDao;
        this.fortuneDao = fortuneDao;
        this.jwtUtil = jwtUtil;
    }
	
	@Override
	public List<User> getUserList() {
		
		List<User> users = userDao.selectAll();
		for (User user : users)
			System.out.println(user);
		return users;
	}
	
	@Override
	public User getUser(String accountId) {
		
		User user = userDao.selectOne(accountId);
		System.out.println(user);
		return user;
	}

	// 비밀번호 암호화 ~ Spring-Security ~ 비밀번호 암호화&검증은 Service 쪽에서
	
	@Override
	public boolean signup(User user) {
		
		String birthDate = user.getBirthDate().toString().substring(5);
		Zodiac zodiac = zodiacDao.selectOne(birthDate);
		user.setZodiacSign(zodiac.getName());
		
		boolean result = userDao.insertUser(user) == 1;
		System.out.println(user + " | " + result);
		return result;
	}
	
	@Override
	public boolean modifyUser(User user) {
		
		String birthDate = user.getBirthDate().toString().substring(5);
		Zodiac zodiac = zodiacDao.selectOne(birthDate);
		user.setZodiacSign(zodiac.getName());
		
		boolean result = userDao.updateUser(user) == 1;
		System.out.println(user + " | " + result);
		return result;
	}

	@Override
	public String login(LoginRequest loginRequest) {
		
		User user = userDao.validateUser(loginRequest);
		
		System.out.println(user);
		if (user == null)
			return null;
		
		return jwtUtil.createToken(loginRequest.getAccountId());
	}
	
	@Override
	public String getPasswordHint(PasswordFinder finder) {
		
		String password = userDao.getPasswordHintByNickname(finder);
	    
		if (password == null || password.length() < 2) {
	        System.out.println(password);
	        return password;
	    }

	    String passwordHint = password.substring(0, 2) + "*".repeat(password.length() - 2);
	    System.out.println(passwordHint);
	    return passwordHint;
	}
	
	@Override
	public Fortune getFortune(String accountId) {
		
		User user = userDao.selectOne(accountId);
		String zodiacSign = user.getZodiacSign();
		List<Fortune> fortunes = fortuneDao.selectAll(zodiacSign);

		LocalDate now = LocalDate.now();
		int dayOfMonth = now.getDayOfMonth();
		int index = (dayOfMonth - 1) % fortunes.size();
		
		Fortune fortune = fortunes.get(index);
		System.out.println(fortune);
		return fortune;
	}

}
