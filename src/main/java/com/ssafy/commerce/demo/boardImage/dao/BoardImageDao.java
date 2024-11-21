package com.ssafy.commerce.demo.boardImage.dao;

import java.util.List;

import com.ssafy.commerce.demo.boardImage.dto.BoardImage;

public interface BoardImageDao {
	
	public List<BoardImage> selectAllThumbs();

	public List<BoardImage> selectAll(int boardId);
	
	public BoardImage selectOne(int id);
	
	public int insertFile(BoardImage firebase);
	
	public int deleteFile(int id);
	
}
