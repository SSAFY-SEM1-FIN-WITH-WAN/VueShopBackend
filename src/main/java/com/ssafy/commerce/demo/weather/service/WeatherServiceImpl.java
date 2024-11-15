package com.ssafy.commerce.demo.weather.service;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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

	@Autowired
	private ObjectMapper objectMapper;
	
	@Value("${service.key}")
	private String serviceKey;
	
    public WeatherResponseDto requestWeather(double longitude, double latitude) throws IOException{
        FormattingTime formattedTime = getFormattedTime();
        StringBuilder urlBuilder = getUrlBuilder((int) longitude, (int) latitude, formattedTime);

        URL url = new URL(urlBuilder.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        StringBuilder sb = writeContent(conn);
        conn.disconnect();
        return parseWeatherResponse(sb.toString());
    }

    private static StringBuilder writeContent(HttpURLConnection conn) throws IOException {
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
        return sb;
    }

    private StringBuilder getUrlBuilder(int longitude, int latitude,
        FormattingTime formattedTime) throws UnsupportedEncodingException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(
            formattedTime.requestDate().replaceAll("-", ""), "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(
            formattedTime.requestTime(), "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(String.valueOf(
            latitude), "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(String.valueOf(
            longitude), "UTF-8")); /*예보지점의 Y 좌표값*/
        return urlBuilder;
    }

    private static FormattingTime getFormattedTime() {
        String requestDate = String.valueOf(LocalDateTime.now().toLocalDate()).replaceAll("-", "");

        String currenTime = getTime();
        String requestTime = "";
        NearestTimeInfo calculatedTime = getNearestTime(currenTime);
        requestTime = String.valueOf(calculatedTime.selectedTime);
        if(requestTime.length()==3) {
            requestTime="0"+requestTime;
        }
        FormattingTime formattedTime = new FormattingTime(requestDate, requestTime);
        return formattedTime;
    }

    private static NearestTimeInfo getNearestTime(String currentTime) {
        int minDifference = Integer.MAX_VALUE;
        int selectedTime = 0;
        for(String availableTime : TIMEARRAY) {
            String paddedTime = availableTime.length() == 3 ? "0" + availableTime : availableTime;
            int timeDifference = Math.abs(
                Integer.parseInt(currentTime) - Integer.parseInt(paddedTime));
            if(timeDifference<minDifference) {
                minDifference=timeDifference;
                selectedTime = Integer.parseInt(paddedTime);
            }
        }
        return new NearestTimeInfo(minDifference, selectedTime);
    }

    private static String getTime() {
        String time = String.valueOf(LocalDateTime.now().getHour());
        String minute = String.valueOf(LocalDateTime.now().getMinute());
        int transformedMinute = Integer.parseInt(minute);
        transformedMinute/=10;//분을 버림
        String tempTime =time+(Math.round(transformedMinute)*10); //날짜와 시간을 붙이고
        return tempTime;
    }

    private record FormattingTime(String requestDate, String requestTime) {


    }
    // JSON 응답을 WeatherResponseDto로 변환하는 메서드

    private WeatherResponseDto parseWeatherResponse(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, WeatherResponseDto.class);  // ObjectMapper를 사용하여 JSON을 DTO로 변환
    }
    private static class NearestTimeInfo{
        private final int timeDifference;
        private final int selectedTime;
        public NearestTimeInfo(int timeDifference, int selectedTime) {
            this.timeDifference = timeDifference;
            this.selectedTime = selectedTime;
        }

        public int getSelectedTime(){
            return selectedTime;
        }
    }
}
