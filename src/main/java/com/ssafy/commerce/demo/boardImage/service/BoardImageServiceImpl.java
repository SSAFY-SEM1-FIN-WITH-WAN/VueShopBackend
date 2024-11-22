package com.ssafy.commerce.demo.boardImage.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.ssafy.commerce.demo.boardImage.dao.BoardImageDao;
import com.ssafy.commerce.demo.boardImage.dto.BoardImage;

@Service
public class BoardImageServiceImpl implements BoardImageService {

	private final Bucket bucket;
	private final BoardImageDao boardImageDao;
	
	public BoardImageServiceImpl(Bucket bucket, BoardImageDao boardImageDao) {
		this.bucket = bucket;
		this.boardImageDao = boardImageDao;
	}

	@Override
	public List<BoardImage> getBoardImageThumbsList() {

		List<BoardImage> boardImages = boardImageDao.selectAllThumbs();
		for (BoardImage boardImage : boardImages)
			System.out.println(boardImage);
		return boardImages;
	}

	@Override
	public List<BoardImage> getBoardImageList(int boardId) {
		
		List<BoardImage> boardImages = boardImageDao.selectAll(boardId);
		for (BoardImage boardImage : boardImages)
			System.out.println(boardImage);
		return boardImages;
	}

	@Override
	public BoardImage getBoardImage(int id) {
		
		BoardImage boardImage = boardImageDao.selectOne(id);
		System.out.println(boardImage);
		return boardImage;
	}

	@Override
	public boolean uploadDatabase(BoardImage boardImage) {
		
		boolean result = boardImageDao.insertFile(boardImage) == 1;
		System.out.println(boardImage + " | " + result);
		return result;
	}

	@Override
	public boolean deleteDatabase(int id) {
		
		boolean result = boardImageDao.deleteFile(id) == 1;
		System.out.println(result);
		return result;
	}

	@Override
	public BoardImage uploadFirebase(MultipartFile file, int userId, int boardId) throws IOException {
		
		String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String newUniqueName = "images/boards/" + UUID.randomUUID().toString() + fileExtension;

        BoardImage boardImage = new BoardImage();
        boardImage.setUserId(userId);
        boardImage.setBoardId(boardId);
        boardImage.setFileName(newUniqueName);
        
        bucket.create(newUniqueName, file.getBytes(), file.getContentType());
        String filePath = bucket.get(newUniqueName).signUrl(1, TimeUnit.HOURS).toString();
		boardImage.setFilePath(filePath);
        
		return boardImage;
	}

	@Override
	public void deleteFirebase(String fileName) {

		bucket.get(fileName).delete();
	}

}
