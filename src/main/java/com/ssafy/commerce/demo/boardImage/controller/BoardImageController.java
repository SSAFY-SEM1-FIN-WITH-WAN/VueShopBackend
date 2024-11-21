package com.ssafy.commerce.demo.boardImage.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.boardImage.dto.BoardImage;
import com.ssafy.commerce.demo.boardImage.service.BoardImageService;
import com.ssafy.commerce.demo.user.dto.User;
import com.ssafy.commerce.demo.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin("*")
public class BoardImageController {

	private final UserService userService;
	private final BoardImageService firebaseService;
	
	public BoardImageController(UserService userService, BoardImageService firebaseService) {
		this.userService = userService;
		this.firebaseService = firebaseService;
	}
	
	@GetMapping("/thumbs")
	public ResponseEntity<?> firebaseThumbsList() {
		
		List<BoardImage> list = firebaseService.getBoardImageThumbsList();
		
		if (list == null || list.isEmpty())
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<BoardImage>> (list, HttpStatus.OK);
	}
	
	@GetMapping("/{boardId}/images")
	public ResponseEntity<?> firebaseList(@PathVariable int boardId) {
		
		List<BoardImage> list = firebaseService.getBoardImageList(boardId);
		
		if (list == null || list.isEmpty())
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<BoardImage>> (list, HttpStatus.OK);
	}
	
	@PostMapping("/{boardId}/images")
	public ResponseEntity<?> upload(@PathVariable int boardId, @RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		
		boolean results = true;
		for (MultipartFile file : files) {
			if (file != null && !file.isEmpty()) {
				BoardImage firebase = firebaseService.uploadFirebase(file, userId, boardId);
				
				boolean result = firebaseService.uploadDatabase(firebase);
				if (!result) results = false;
			}
		}
		
		if (!results)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{boardId}/iamges/{imageId}")
	public ResponseEntity<?> delete(@PathVariable int imageId, HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		BoardImage firebase = firebaseService.getBoardImage(imageId);
		int savedUserId = firebase.getUserId();
		String adminType = user.getType();
		
		if (!adminType.equals("super"))
			if (userId != savedUserId)
				return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		String fileName = firebase.getFileName();
		
		firebaseService.deleteFirebase(fileName);
		boolean result = firebaseService.deleteDatabase(imageId);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.OK);
	}
}
