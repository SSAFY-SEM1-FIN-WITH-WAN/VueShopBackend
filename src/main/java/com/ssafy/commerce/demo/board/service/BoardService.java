package com.ssafy.commerce.demo.board.service;

import java.util.List;

import com.ssafy.commerce.demo.board.dto.Board;
import com.ssafy.commerce.demo.board.dto.SearchCondition;

public interface BoardService {

	public List<Board> getBoardList();
	
	public List<Board> searchBoard(SearchCondition condition);
	
	public Board getBoard(int id);
	
	public boolean createBoard(Board board);
	
	public boolean modifyBoard(Board board);
	
	public boolean removeBoard(int id);
}