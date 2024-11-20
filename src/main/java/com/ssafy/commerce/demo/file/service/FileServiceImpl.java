package com.ssafy.commerce.demo.file.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.file.dao.ImageFileDao;
import com.ssafy.commerce.demo.file.dto.ImageFile;

@Service
public class FileServiceImpl implements FileService {
	
	private final ImageFileDao imageFileDao;
	private final ResourceLoader resourceLoader;
	
    public FileServiceImpl(ImageFileDao imageFileDao, ResourceLoader resourceLoader) {
        this.imageFileDao = imageFileDao;
        this.resourceLoader = resourceLoader;
    }

	@Override
	public List<ImageFile> getImageFileList(int boardId) {
		
		List<ImageFile> imageFiles = imageFileDao.selectAll(boardId);
		for (ImageFile imageFile : imageFiles)
			System.out.println(imageFile);
		return imageFiles;
	}
	
	@Override
	public ImageFile getImageFileThumb(int boardId) {
		
		ImageFile imageFile = imageFileDao.selectThumb(boardId);
		System.out.println(imageFile);
		return imageFile;
	}

	@Override
	public ImageFile getImageFile(int id) {
		
		ImageFile imageFile = imageFileDao.selectOne(id);
		System.out.println(imageFile);
		return imageFile;
	}

	@Override
	public Resource loadAsResource(String filePath) throws IOException {
		
	    Resource resource = resourceLoader.getResource("classpath:" + filePath);
	    if (!resource.exists() || !resource.isReadable()) {
	        throw new IOException("파일을 읽을 수 없습니다: " + filePath);
	    }
	    return resource;
	}
	
	@Override
	public List<ImageFile> convertImageFile(MultipartFile[] files) throws IllegalStateException, IOException {
		
		List<ImageFile> imageFiles = new ArrayList<>();
		
		if (files != null && files.length > 0) {
			
			Resource resource = resourceLoader.getResource("classpath:/static/image/board");
			File uploadDir = resource.getFile();
			
			if (!uploadDir.exists())
				uploadDir.mkdirs();
			
			for (MultipartFile file : files) {
				
				if (file != null && !file.isEmpty()) {
					
                    String fileId = UUID.randomUUID().toString();
                    String originalFileName = file.getOriginalFilename();
                    String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));

                    String savedFileName = fileId + fileExtension;
                    File savedFile = new File(uploadDir, savedFileName);

                    file.transferTo(savedFile);

                    ImageFile imageFile = new ImageFile();
                    imageFile.setFileId(fileId);
                    imageFile.setFileName(originalFileName);
                    imageFile.setFilePath("/static/image/board/" + savedFileName);

                    imageFiles.add(imageFile);
				}
			}
		}
		
		for (ImageFile imageFile : imageFiles)
			System.out.println(imageFile);
		return imageFiles;
	}

	@Override
	public boolean uploadImageFile(ImageFile imageFile) {
		
		boolean result = imageFileDao.insertFile(imageFile) == 1;
		System.out.println(imageFile + " | " + result);
		return result;
	}

	@Override
	public boolean removeImageFile(int id) throws IOException {
		
		ImageFile imageFile = imageFileDao.selectOne(id);
		
		if (imageFile != null) {
			Resource resource = resourceLoader.getResource("classpath:" + imageFile.getFilePath());
			
			File savedFile = resource.getFile();
			if (savedFile.exists()) {
				if (savedFile.delete()) {
					System.out.println("파일 삭제에 성공했습니다: " + savedFile.getPath());
					return imageFileDao.deleteFile(id) > 0;
				} else
					throw new IOException("파일 삭제에 실패하였습니다: " + savedFile.getPath());
			} else
				throw new IOException("파일이 존재하지 않습니다: " + savedFile.getPath());
		}
		
		System.out.println(false);
		return false;
	}

}
