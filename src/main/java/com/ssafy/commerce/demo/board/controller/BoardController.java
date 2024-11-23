package com.ssafy.commerce.demo.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.commerce.demo.board.dto.Board;
import com.ssafy.commerce.demo.board.dto.SearchCondition;
import com.ssafy.commerce.demo.board.service.BoardService;
import com.ssafy.commerce.demo.user.dto.User;
import com.ssafy.commerce.demo.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin("*")
public class BoardController {

	private final UserService userService;
	private final BoardService boardService;
	
	public BoardController(UserService userService, BoardService boardService) {
		this.userService = userService;
		this.boardService = boardService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> boardList() {
		
		List<Board> list = boardService.getBoardList();
		if (list == null || list.isEmpty())
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Board>> (list, HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition) {
		
		List<Board> list = boardService.searchBoard(condition);
		if (list == null || list.isEmpty())
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Board>> (list, HttpStatus.OK);
	}
	
	@GetMapping("/{boardId}")
	public ResponseEntity<?> detail(@PathVariable int boardId) {
		
		Board board = boardService.getBoard(boardId);
		if (board == null)
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Board> (board, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Board board, HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		String userName = user.getNickname();
		
		board.setUserId(userId);
		board.setUserName(userName);
		
		boolean result = boardService.createBoard(board);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Board> (board, HttpStatus.CREATED);
	}
	
	@PutMapping("/{boardId}")
	public ResponseEntity<?> update(@PathVariable int boardId, @RequestBody Board board, HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		
		Board savedBoard = boardService.getBoard(boardId);
		int savedUserId = savedBoard.getUserId();

		if (userId != savedUserId)
			return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		savedBoard.setTitle(board.getTitle());
		savedBoard.setContent(board.getContent());
		
		boolean result = boardService.modifyBoard(savedBoard);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{boardId}")
	public ResponseEntity<?> delete(@PathVariable int boardId, HttpServletRequest request) {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		String adminType = user.getType();
		
		Board board = boardService.getBoard(boardId);
		int savedUserId = board.getUserId();
		
		if (!adminType.equals("super"))
			if (userId != savedUserId)
				return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		boolean result = boardService.removeBoard(boardId);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.OK);
	}
}
