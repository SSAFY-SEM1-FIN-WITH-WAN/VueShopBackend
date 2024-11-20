package com.ssafy.commerce.demo.file.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.file.dto.ImageFile;
import com.ssafy.commerce.demo.file.service.FileService;
import com.ssafy.commerce.demo.user.dto.User;
import com.ssafy.commerce.demo.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin("*")
public class FileController {
	
	private final UserService userService;
	private final FileService fileService;
	
	public FileController(UserService userService, FileService fileService) {
		this.userService = userService;
		this.fileService = fileService;
	}
	
	@GetMapping("/{boardId}/images")
	public ResponseEntity<?> fileList(@PathVariable int boardId) {
		
        try {
            List<ImageFile> imageFiles = fileService.getImageFileList(boardId);
            List<Resource> resources = new ArrayList<>();

            for (ImageFile imageFile : imageFiles) {
                Resource resource = fileService.loadAsResource(imageFile.getFilePath());
                resources.add(resource);
            }

            if (resources.isEmpty())
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<List<Resource>>(resources, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@GetMapping("/{boardId}/images/thumb")
    public ResponseEntity<?> file(@PathVariable int boardId) {
    	
        try {
            ImageFile imageFile = fileService.getImageFileThumb(boardId);
            if (imageFile == null) {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }

            Resource resource = fileService.loadAsResource(imageFile.getFilePath());
            if (resource == null)
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<Resource>(resource, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PostMapping("/{boardId}/images")
	public ResponseEntity<?> create(@PathVariable int boardId, @RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IllegalStateException, IOException {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		
		List<ImageFile> imageFiles = fileService.convertImageFile(files);
		
		boolean results = true;
		for (ImageFile imageFile : imageFiles) {
			imageFile.setUserId(userId);
			imageFile.setBoardId(boardId);
			
			boolean result = fileService.uploadImageFile(imageFile);
			if (!result) results = false;
		}
		
		if (!results)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{boardId}/images/{imageId}")
	public ResponseEntity<?> delete(@PathVariable int imageId, HttpServletRequest request) throws IOException {
		
		String accountId = (String) request.getAttribute("accountId");
		User user = userService.getUser(accountId);
		int userId = user.getId();
		ImageFile imageFile = fileService.getImageFile(imageId);
		int savedUserId = imageFile.getUserId();
		String adminType = user.getType();
		
		if (!adminType.equals("super"))
			if (userId != savedUserId)
				return new ResponseEntity<Void> (HttpStatus.UNAUTHORIZED);
		
		boolean result = fileService.removeImageFile(imageId);
		if (!result)
			return new ResponseEntity<Void> (HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Void> (HttpStatus.OK);
	}
	
}
