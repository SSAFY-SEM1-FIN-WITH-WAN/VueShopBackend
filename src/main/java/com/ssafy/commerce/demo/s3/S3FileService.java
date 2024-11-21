package com.ssafy.commerce.demo.s3;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Service
public class S3FileService {

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

	public String uploadFileToS3(String objectPath, String key) {
		Path path = Paths.get(objectPath);
		PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
		try {
            // 파일 업로드
            PutObjectResponse response = s3Client.putObject(putObjectRequest, path);
            System.out.println("File uploaded successfully with ETag: " + response.eTag());
            return "File uploaded successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        }
	}
}
