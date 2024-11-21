package com.ssafy.commerce.demo.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@RestController
public class S3FileController {

    @Autowired
    private S3FileService s3FileService;

    @GetMapping("/download")
    public String downloadFile(@RequestParam String objectKey, @RequestParam String downloadFilePath) {
        s3FileService.downloadFileFromS3(objectKey, downloadFilePath);
        return "File downloaded successfully!";
    }
    
    @PostMapping("/upload")
    public String uploadFile(@RequestParam String objectKey, @RequestParam String filePath) {
    	return s3FileService.uploadFileToS3(filePath,objectKey);
    	
    }
}
