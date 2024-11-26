package com.ssafy.commerce.demo.s3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.s3.service.S3FileService;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@RestController
@RequestMapping("/api")
public class S3FileController {

    @Autowired
    private S3FileService s3FileService;

    @GetMapping("/download")
    public String downloadFile(@RequestParam String objectKey, @RequestParam String downloadFilePath) {
        s3FileService.downloadFileFromS3(objectKey, downloadFilePath);
        return "File downloaded successfully!";
    }
    
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam double minTMP,@RequestParam double maxTMP) {
        try {
            // 파일을 S3로 업로드하고, 업로드된 파일의 고유 objectKey를 반환
            String objectKey = s3FileService.uploadFileToS3(file,minTMP,maxTMP);
            return "File uploaded successfully with object key: " + objectKey;
        } catch (Exception e) {
            e.printStackTrace();
            return "File upload failed: " + e.getMessage();
        }
    }
}
