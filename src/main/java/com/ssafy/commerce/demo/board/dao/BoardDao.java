package com.ssafy.commerce.demo.board.dao;

import java.util.List;

import com.ssafy.commerce.demo.board.dto.Board;
import com.ssafy.commerce.demo.board.dto.SearchCondition;

public interface BoardDao {

	public List<Board> selectAll();
	
	public List<Board> search(SearchCondition condition);
	
	public Board selectOne(int id);
	
	public void updateViewCnt(int id);
	
	public int insertBoard(Board board);
	
	public int updateBoard(Board board);
	
	public int deleteBoard(int id);
}