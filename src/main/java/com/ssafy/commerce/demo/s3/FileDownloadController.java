package com.ssafy.commerce.demo.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {

    @Autowired
    private S3FileService s3FileService;

    @GetMapping("/download")
    public String downloadFile(@RequestParam String objectKey, @RequestParam String downloadFilePath) {
        s3FileService.downloadFileFromS3(objectKey, downloadFilePath);
        return "File downloaded successfully!";
    }
}
