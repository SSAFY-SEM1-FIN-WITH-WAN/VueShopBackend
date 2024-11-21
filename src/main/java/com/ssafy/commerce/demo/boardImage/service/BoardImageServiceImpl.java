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
	private final BoardImageDao firebaseDao;
	
	public BoardImageServiceImpl(Bucket bucket, BoardImageDao firebaseDao) {
		this.bucket = bucket;
		this.firebaseDao = firebaseDao;
	}

	@Override
	public List<BoardImage> getBoardImageThumbsList() {

		List<BoardImage> firebases = firebaseDao.selectAllThumbs();
		for (BoardImage firebase : firebases)
			System.out.println(firebase);
		return firebases;
	}

	@Override
	public List<BoardImage> getBoardImageList(int boardId) {
		
		List<BoardImage> firebases = firebaseDao.selectAll(boardId);
		for (BoardImage firebase : firebases)
			System.out.println(firebase);
		return firebases;
	}

	@Override
	public BoardImage getBoardImage(int id) {
		
		BoardImage firebase = firebaseDao.selectOne(id);
		System.out.println(firebase);
		return firebase;
	}

	@Override
	public boolean uploadDatabase(BoardImage firebase) {
		
		boolean result = firebaseDao.insertFile(firebase) == 1;
		System.out.println(firebase + " | " + result);
		return result;
	}

	@Override
	public boolean deleteDatabase(int id) {
		
		boolean result = firebaseDao.deleteFile(id) == 1;
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
