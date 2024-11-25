package com.ssafy.commerce.demo.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.commerce.demo.comment.dto.Comment;
import com.ssafy.commerce.demo.comment.dto.CommentWithUserProfile;
import com.ssafy.commerce.demo.comment.service.CommentService;
import com.ssafy.commerce.demo.user.dto.User;
import com.ssafy.commerce.demo.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin("*")
public class CommentController {

	private final UserService userService;
	private final CommentService commentService;
	
	public CommentController(UserService userService, CommentService commentService) {
		this.userService = userService;
		this.commentService = commentService;
	}
	
//	@GetMapping("/{boardId}/comments")
//	public ResponseEntity<?> commentList(@PathVariable int boardId) {
//		
//		List<Comment> list = commentService.getCommentList(boardId);
//		if (list == null || list.isEmpty())
//			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
//		
//		return new ResponseEntity<List<Comment>> (list, HttpStatus.OK);
//	}
	
	@GetMapping("/{boardId}/comments")
	public ResponseEntity<?> commentList(@PathVariable int boardId) {
		
		List<CommentWithUserProfile> list = commentService.getCommentList(boardId);
		if (list == null || list.isEmpty())
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<CommentWithUserProfile>> (list, HttpStatus.OK);
	}
	
	@PostMapping("/{boardId}/comments")
	public ResponseEntity<?> create(@PathVariable int boardId, @RequestBody Comment comment, HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		String userName = user.getNickname();
		
		comment.setUserId(userId);
		comment.setUserName(userName);
		comment.setBoardId(boardId);
		
		boolean result = commentService.addComment(comment);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@PutMapping("/{boardId}/comments/{commentId}")
	public ResponseEntity<?> update(@PathVariable int commentId, @RequestBody Comment comment, HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		
		Comment savedComment = commentService.getComment(commentId);
		int savedUserId = savedComment.getUserId();
		
		if (userId != savedUserId)
			return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		savedComment.setContent(comment.getContent());
		
		boolean result = commentService.modifyComment(savedComment);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{boardId}/comments/{commentId}")
	public ResponseEntity<?> delete(@PathVariable int commentId, HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		String adminType = user.getType();
		
		Comment comment = commentService.getComment(commentId);
		int savedUserId = comment.getUserId();
		
		if (!adminType.equals("super"))
			if (userId != savedUserId)
				return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		boolean result = commentService.removeComment(commentId);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.OK);
	}
}
