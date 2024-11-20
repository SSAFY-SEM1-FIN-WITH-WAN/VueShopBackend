package com.ssafy.commerce.demo.weather.service;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.commerce.demo.weather.dto.WeatherResponseDto;
import java.io.BufferedReader;
import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService{

    static final String[] TIMEARRAY = new String[] {"200", "500", "800", "1100", "1400", "1700", "2000", "2300"};
    
    private static final String ENCODING = "UTF-8";
    public static final String PARAM_PAGE_NO = "pageNo";
    
    public static final String PARAM_ROWS = "numOfRows";
    
    public static final String PARAM_DATA_TYPE = "dataType";
    public static final String DEFAULT_DATA_TYPE = "JSON";
    public static final String BASE_DATE = "base_date";
    public static final String BASE_TIME = "base_time";
    public static final String NX = "nx";
    public static final String NY = "ny";
    public static final String SERVICE_KEY = "serviceKey";

    public static final String reqDate = String.valueOf(LocalDateTime.now().toLocalDate()).replaceAll("-","");
    
    @Autowired
	private ObjectMapper objectMapper;

    @Value("${service.key}")
	private String serviceKey;

    public WeatherResponseDto requestWeather(double longitude, double latitude,String type,String timeValue,String pageNo,String page) throws IOException{
        StringBuilder urlBuilder = getUrlBuilder((int) longitude, (int) latitude, reqDate, timeValue, type,pageNo,page);
//        System.out.println(urlBuilder.toString());
        URL url = new URL(urlBuilder.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        StringBuilder sb = writeContent(conn);
        conn.disconnect();
        return parseWeatherResponse(sb.toString());
    }
    private static StringBuilder writeContent(HttpURLConnection conn) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean isSuccess = conn.getResponseCode() < HTTP_BAD_REQUEST;

        try (BufferedReader rd = isSuccess?
            new BufferedReader(new InputStreamReader(conn.getInputStream())):
            new BufferedReader(new InputStreamReader(conn.getErrorStream()))
            ) {
            String line;
            while ((line = rd.readLine()) != null) {
//            	System.out.println(line);
            	
//            	System.out.println("===============");
                sb.append(line);
            }
            if (!isSuccess) {
                throw new IOException("API request failed with status " + conn.getResponseCode());
            }
        }
        return sb;
    }
    private StringBuilder getUrlBuilder(int longitude, int latitude,
        String reqDate, String reqTime, String type, String pageNo, String pageRows) throws UnsupportedEncodingException {
        StringBuilder urlBuilder = new StringBuilder(type); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode(SERVICE_KEY,ENCODING) + "="+serviceKey); /*Service Key*/
        urlBuilder.append(appendUrlParameter(PARAM_PAGE_NO, pageNo)); /*페이지번호*/
        urlBuilder.append(appendUrlParameter(PARAM_ROWS, pageRows));
        urlBuilder.append(appendUrlParameter(PARAM_DATA_TYPE, DEFAULT_DATA_TYPE));
        urlBuilder.append(appendUrlParameter(
            BASE_DATE,reqDate));
        urlBuilder.append(appendUrlParameter(BASE_TIME,reqTime));
        urlBuilder.append(appendUrlParameter(NX,String.valueOf(latitude)));
        urlBuilder.append(appendUrlParameter(NY,String.valueOf(longitude)));
        return urlBuilder;
    }
    private static String appendUrlParameter(String key,String value) throws UnsupportedEncodingException {
        return "&" + URLEncoder.encode(key, ENCODING) + "=" + URLEncoder.encode(value, ENCODING);
    }

    // JSON 응답을 WeatherResponseDto로 변환하는 메서드
    private WeatherResponseDto parseWeatherResponse(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, WeatherResponseDto.class);  // ObjectMapper를 사용하여 JSON을 DTO로 변환
    }
}
