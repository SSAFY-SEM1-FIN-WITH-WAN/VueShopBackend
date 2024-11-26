package com.ssafy.commerce.demo.config;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

import jakarta.annotation.PostConstruct;

@Configuration
public class FirebaseConfig {
	
    @Value("${firebase.key-path}")
    private String firebaseKeyPath;
    
	@Value("${firebase.storage-url}")
	private String firebaseStorageUrl;

    @PostConstruct
    public FirebaseApp firebaseApp() throws IOException {
        if(FirebaseApp.getApps().isEmpty()){
        	InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream(firebaseKeyPath);
        	if (serviceAccount == null) {
        	    throw new IllegalStateException("Firebase key not found at path: " + firebaseKeyPath);
        	}

//            FileInputStream serviceAccount  = new FileInputStream(firebaseKeyPath);//local

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket(firebaseStorageUrl)
                    .build();

            return FirebaseApp.initializeApp(options);
        }
        
        return FirebaseApp.getInstance();
    }
    
    @Bean
    public Bucket bucket() throws IOException {
    	return StorageClient.getInstance(firebaseApp()).bucket();
    }
}
