package com.ssafy.commerce.demo.s3.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.s3.dao.ClothImageDao;
import com.ssafy.commerce.demo.s3.entity.ClothImage;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Service
public class S3FileService {

	@Autowired
	private ClothImageDao imageDao;
	
    @Autowired
    private S3Client s3Client;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucketName;

    // 파일 다운로드 메서드
    public void downloadFileFromS3(String objectKey, String downloadFilePath) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        // S3에서 파일을 가져와 로컬에 저장
        try {
            s3Client.getObject(getObjectRequest, Paths.get(downloadFilePath));
            System.out.println("File downloaded successfully to " + downloadFilePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to download the file: " + e.getMessage());
        }
    }

    public String uploadFileToS3(MultipartFile file) throws IOException {
        // UUID와 파일 이름, 타임스탬프를 결합하여 고유 objectKey 생성
        String fileName = file.getOriginalFilename();
        String uniqueFileName = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_" + fileName;

        // 파일을 임시 디스크에 저장 (예시)
        File tempFile = Files.createTempFile(UUID.randomUUID().toString(), ".tmp").toFile();
        file.transferTo(tempFile);

        // S3 업로드 요청
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(uniqueFileName)  // 고유 objectKey 사용
                .build();

        s3Client.putObject(putObjectRequest, tempFile.toPath());

        // 임시 파일 삭제
        tempFile.delete();
        ClothImage image = new ClothImage();
        image.setOriginalName(fileName);
        image.setUniqueName(uniqueFileName);
        imageDao.insertImage(image);
        return uniqueFileName;  // S3에 업로드된 고유 파일명 반환
    }
}
