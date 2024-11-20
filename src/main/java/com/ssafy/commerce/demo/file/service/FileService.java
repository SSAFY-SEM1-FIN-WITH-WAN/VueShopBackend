package com.ssafy.commerce.demo.file.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.file.dto.ImageFile;

public interface FileService {

	public List<ImageFile> getImageFileList(int boardId);
	
	public ImageFile getImageFileThumb(int boardId);
	
	public ImageFile getImageFile(int id);
	
	public Resource loadAsResource(String filePath) throws IOException;
	
	public List<ImageFile> convertImageFile(MultipartFile[] files) throws IllegalStateException, IOException;
	
	public boolean uploadImageFile(ImageFile imageFile);
	
	public boolean removeImageFile(int id) throws IOException;
}
