package com.ssafy.commerce.demo.scrap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.commerce.demo.s3.service.S3FileService;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;

@Service
public class ScrappingService {
    
    private static final String BASE_URL = "https://www.musinsa.com"; // 기본 URL
    @Autowired
    private S3FileService s3FileService;
    
    @Value("${webdriver.chrome.driver}")
    private String driverPath;
    
    public void scrap() throws IOException {
        // Selenium WebDriver 설정
        System.setProperty("webdriver.chrome.driver", driverPath); // ChromeDriver 경로 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // 헤드리스 모드 (UI 없이 실행)
        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.get("https://www.musinsa.com/app/codimap/lists?tag_no=&brand=&max_rt=&min_rt=&year_date=&month_date=&display_cnt=24&list_kind=small&page=1&style_type=&sort=comment_cnt&list_type=&specialty_code=");

            // 동적 이미지 로드 대기
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.style-list-thumbnail__img")));

            // img 태그의 'data-original' 속성 값 가져오기
            List<WebElement> images = driver.findElements(By.cssSelector("img.style-list-thumbnail__img"));
            for (WebElement image : images) {
                String imgsrc = image.getAttribute("data-original");

                // 절대 URL로 변환
                String absoluteImgUrl = convertToAbsoluteUrl(imgsrc);

                // 이미지 URL을 MultipartFile로 변환 후 S3에 업로드
                uploadImageToS3(absoluteImgUrl);

                System.out.println("Image URL: " + absoluteImgUrl);
            }
        } finally {
            driver.quit(); // WebDriver 종료
        }
    }

    private String convertToAbsoluteUrl(String imgsrc) {
        if (imgsrc.startsWith("http")) {
            return imgsrc; // 이미 절대 URL이라면 그대로 반환
        }
        return BASE_URL + imgsrc; // 상대 URL을 절대 URL로 변환
    }
    
    private MultipartFile convertToMultipartFile(byte[] fileBytes) {
        // ByteArrayResource를 사용하여 MultipartFile로 변환
        ByteArrayResource byteArrayResource = new ByteArrayResource(fileBytes) {
            @Override
            public String getFilename() {
                return "image.jpg";  // 파일명을 지정
            }
        };

        // MultipartFile로 변환하여 반환
        return new MultipartFile() {
            @Override
            public String getName() {
                return "file";
            }

            @Override
            public String getOriginalFilename() {
                return "image.jpg";
            }

            @Override
            public String getContentType() {
                return "image/jpeg";  // 이미지 형식에 맞게 설정
            }

            @Override
            public boolean isEmpty() {
                return fileBytes.length == 0;
            }

            @Override
            public long getSize() {
                return fileBytes.length;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return fileBytes;
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return new ByteArrayInputStream(fileBytes);
            }

            @Override
            public void transferTo(java.io.File dest) throws IOException, IllegalStateException {
                // 필요 시 구현
            }
        };
    }

    private void uploadImageToS3(String imgUrl) throws IOException {
        // RestTemplate을 사용하여 이미지 URL에서 바이트 배열을 다운로드
        RestTemplate restTemplate = new RestTemplate();
        byte[] imageBytes = restTemplate.getForObject(imgUrl, byte[].class);

        // 바이트 배열을 InputStream으로 변환
        InputStream inputStream = new ByteArrayInputStream(imageBytes);

        // MultipartFile로 변환
        MultipartFile multipartFile = convertToMultipartFile(imageBytes);

        // S3에 파일 업로드
        s3FileService.uploadFileToS3(multipartFile, -40, 40);  // 매개변수 값은 필요에 따라 조정
    }
}
