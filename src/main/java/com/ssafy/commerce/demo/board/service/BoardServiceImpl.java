package com.ssafy.commerce.demo.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.commerce.demo.board.dao.BoardDao;
import com.ssafy.commerce.demo.board.dto.Board;
import com.ssafy.commerce.demo.board.dto.BoardWithUserProfile;
import com.ssafy.commerce.demo.board.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

//	@Override
//	public List<Board> getBoardList() {
//		
//		List<Board> boards = boardDao.selectAll();
//		for (Board board : boards)
//			System.out.println(board);
//		return boards;
//	}
//
//	@Override
//	public List<Board> searchBoard(SearchCondition condition) {
//		
//		List<Board> boards = boardDao.search(condition);
//		for (Board board : boards)
//			System.out.println(board);
//		return boards;
//	}
//
//	@Override
//	public Board getBoard(int id) {
//		
//		Board board = boardDao.selectOne(id);
//		boardDao.updateViewCnt(id);
//		System.out.println(board);
//		return board;
//	}
	
	@Override
	public List<BoardWithUserProfile> getBoardList() {
		
		List<BoardWithUserProfile> boards = boardDao.selectAll();
		for (BoardWithUserProfile board : boards)
			System.out.println(board);
		return boards;
	}
	
	@Override
	public List<BoardWithUserProfile> searchBoard(SearchCondition condition) {
		
		List<BoardWithUserProfile> boards = boardDao.search(condition);
		for (BoardWithUserProfile board : boards)
			System.out.println(board);
		return boards;
	}
	
	@Override
	public BoardWithUserProfile getBoard(int id) {
		
		BoardWithUserProfile board = boardDao.selectOne(id);
		boardDao.updateViewCnt(id);
		System.out.println(board);
		return board;
	}

	@Override
	public boolean createBoard(Board board) {
		
		boolean result = boardDao.insertBoard(board) == 1;
		System.out.println(board + " | " + result);
		return result;
	}

	@Override
//	public boolean modifyBoard(Board board) {
	public boolean modifyBoard(BoardWithUserProfile board) {
		
		boolean result = boardDao.updateBoard(board) == 1;
		System.out.println(board + " | " + result);
		return result;
	}

	@Override
	public boolean removeBoard(int id) {
		
		boolean result = boardDao.deleteBoard(id) == 1;
		System.out.println(id + " | " + result);
		return result;
	}

}
