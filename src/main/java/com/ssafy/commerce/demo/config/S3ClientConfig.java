package com.ssafy.commerce.demo.config;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3ClientConfig {

	@Value("${spring.cloud.aws.s3.region}")
	private String regionPath;
	
	@Value("${spring.cloud.aws.credentials.access-key}")
	private String accessKey;
	
	@Value("${spring.cloud.aws.credentials.secret-key}")
	private String secretKey;
    
    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(regionPath))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)
                ))
                .build();
    }
}