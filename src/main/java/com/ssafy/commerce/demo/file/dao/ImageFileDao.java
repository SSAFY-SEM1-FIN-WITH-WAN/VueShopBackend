package com.ssafy.commerce.demo.file.dao;

import java.util.List;

import com.ssafy.commerce.demo.file.dto.ImageFile;

public interface ImageFileDao {
	
	public List<ImageFile> selectAll(int boardId);
	
	public ImageFile selectThumb(int boardId);
	
	public ImageFile selectOne(int id);
	
	public int insertFile(ImageFile imageFile);
	
	public int deleteFile(int id);
}
