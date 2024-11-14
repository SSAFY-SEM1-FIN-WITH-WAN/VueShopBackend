package com.ssafy.commerce.demo.weather.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.commerce.demo.weather.dto.WeatherResponseDto;
import java.io.BufferedReader;
import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
	private ObjectMapper objectMapper;
	
	static int[] temp = new int[] {200, 500, 800, 1100, 1400, 1700, 2000, 2300};
    public WeatherResponseDto requestWeather(double longitude, double latitude) throws IOException{
    	String requestDate = String.valueOf(LocalDateTime.now().toLocalDate()).replaceAll("-", "");
		String time = String.valueOf(LocalDateTime.now().getHour());
		String minute = String.valueOf(LocalDateTime.now().getMinute());
		int transformedMinute = Integer.parseInt(minute);
		transformedMinute/=10;
		String tempTime =time+(Math.round(transformedMinute)*10);
		String requestTime = "";
		int result[] =new int[2];
		result[0]=Integer.MAX_VALUE;
		for(int i = 0;i<temp.length;i++) {
			if(String.valueOf(temp[i]).length()==3) {
				temp[i]=Integer.parseInt("0"+String.valueOf(temp[i]));
			}
			if(result[0]>Math.abs(Integer.parseInt(tempTime)-temp[i])) {
				result[0] = Math.abs(Integer.parseInt(tempTime)-temp[i]);
				result[1]=temp[i];
			}
		}
		requestTime = String.valueOf(result[1]);
		if(requestTime.length()==3) {
			requestTime="0"+requestTime;
		}
		System.out.println(requestTime);
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=Buo9K03oI9UCt%2FCuWNg%2FHcdugYFepoyIPhF2IzIkY4EWK3pD1kFaGEYiHgdffT7H93PPBjWO%2FW09olyAKpnUpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(requestDate.replaceAll("-", ""), "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(requestTime, "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(String.valueOf((int)latitude), "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(String.valueOf((int)longitude), "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
//        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        return parseWeatherResponse(sb.toString());
    }
    
    // JSON 응답을 WeatherResponseDto로 변환하는 메서드
    private WeatherResponseDto parseWeatherResponse(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, WeatherResponseDto.class);  // ObjectMapper를 사용하여 JSON을 DTO로 변환
    }
}
