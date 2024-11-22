package com.ssafy.commerce.demo.user.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Bucket;
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
	
	private final Bucket bucket;
	private final UserDao userDao;
	private final ZodiacDao zodiacDao;
	private final FortuneDao fortuneDao;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(Bucket bucket, UserDao userDao, ZodiacDao zodiacDao, FortuneDao fortuneDao, JwtUtil jwtUtil) {
		this.bucket = bucket;
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

	@Override
	public boolean updateDatebase(User user) {
		
		boolean result = userDao.updateProfile(user) == 1;
		System.out.println(user + " | " + result);
		return result;
	}

	@Override
	public User uploadFirebase(MultipartFile file, User user) throws IOException {

		String deletedFileName = user.getFileName();
		if (!deletedFileName.equals(DEFAULT_FILE_NAME))
			deleteFirebase(deletedFileName);
		
		String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String newUniqueName = "images/profiles/" + UUID.randomUUID().toString() + fileExtension;
        
        bucket.create(newUniqueName, file.getBytes(), file.getContentType());
        String filePath = bucket.get(newUniqueName).signUrl(10, TimeUnit.DAYS).toString();

        user.setFileName(newUniqueName);
        user.setFilePath(filePath);
        
        return user;
	}

	static final String DEFAULT_FILE_NAME = "images/profiles/980970d3-3772-4a59-9f1c-a02680e19720.png";
	static final String DEFAULT_FILE_PATH = "https://firebasestorage.googleapis.com/v0/b/whatsyoulook-11c33"
								+ ".firebasestorage.app/o/images%2Fprofiles%2F980970d3-3772-4a59-9f1c-a02680e19720"
								+ ".png?alt=media&token=5a619049-f799-432e-aac2-bbeced00195f";
	
	@Override
	public User resetDatabase(User user) {
		
		user.setFileName(DEFAULT_FILE_NAME);
		user.setFilePath(DEFAULT_FILE_PATH);
		
		return user;
	}

	@Override
	public void deleteFirebase(String fileName) {

		bucket.get(fileName).delete();
	}

}
