package com.ssafy.commerce.demo.boardImage.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.boardImage.dto.BoardImage;

public interface BoardImageService {
	
	public List<BoardImage> getBoardImageThumbsList();
	
	public List<BoardImage> getBoardImageList(int boardId);
	
	public BoardImage getBoardImage(int id);
	
	public boolean uploadDatabase(BoardImage firebase);
	
	public boolean deleteDatabase(int id);
	
	public BoardImage uploadFirebase(MultipartFile file, int userId, int boardId) throws IOException;
	
	public void deleteFirebase(String fileName);
}
