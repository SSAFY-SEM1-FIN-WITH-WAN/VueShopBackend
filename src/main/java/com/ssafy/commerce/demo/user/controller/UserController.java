package com.ssafy.commerce.demo.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.user.dto.Fortune;
import com.ssafy.commerce.demo.user.dto.LoginRequest;
import com.ssafy.commerce.demo.user.dto.PasswordFinder;
import com.ssafy.commerce.demo.user.dto.User;
import com.ssafy.commerce.demo.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/admin")
	public ResponseEntity<?> userList(HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User loginUser = userService.getUser(accountId);
		String adminType = loginUser.getType();
		
		if (adminType.equals("normal"))
			return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		List<User> list = userService.getUserList();
		if (list == null || list.isEmpty())
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<User>> (list, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<?> user(HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User loginUser = userService.getUser(accountId);
		
		if (loginUser == null)
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<User> (loginUser, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> register(@RequestBody User user) {
		
		if (!userService.signup(user))
			return new ResponseEntity<Void> (HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		
		String token = userService.login(loginRequest);
		
		if (token == null)
			return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		Map<String, String> header = new HashMap<>();
		header.put("access-token", token);
		
		return new ResponseEntity<Map<String, String>> (header, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/info")
	public ResponseEntity<?> update(@RequestBody User user, HttpServletRequest request) {
		
		String loginAccountId = (String) request.getAttribute("accountId");
		User loginUser = userService.getUser(loginAccountId);
		int loginUserId = loginUser.getId();
		
		user.setId(loginUserId);
		
		if (!userService.modifyUser(user))
			return new ResponseEntity<Void> (HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@PostMapping("/password")
	public ResponseEntity<?> find(@RequestBody PasswordFinder finder) {
		
		String passwordHint = userService.getPasswordHint(finder);
		
		if (passwordHint == null)
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<String> (passwordHint, HttpStatus.OK);
	}
	
	@GetMapping("/fortune")
	public ResponseEntity<?> fortune(HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		Fortune fortune = userService.getFortune(accountId);
		
		if (fortune == null)
			return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		return new ResponseEntity<Fortune> (fortune, HttpStatus.OK);
	}
	
	@PutMapping("/profile/update")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		
		User newUser = userService.uploadFirebase(file, user);
		
		boolean result = userService.updateDatebase(newUser);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@PutMapping("/profile/reset")
	public ResponseEntity<?> reset(HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		
		User newUser = userService.resetDatabase(user);
		
		boolean result = userService.updateDatebase(newUser);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
}
