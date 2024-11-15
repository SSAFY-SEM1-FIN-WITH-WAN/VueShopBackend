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
    private static final String WEATHER_REQUEST_BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
    private static final String ENCODING = "UTF-8";

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
        StringBuilder sb = new StringBuilder();
        boolean isSuccess = conn.getResponseCode() < HTTP_BAD_REQUEST;

        try (BufferedReader rd = isSuccess?
            new BufferedReader(new InputStreamReader(conn.getInputStream())):
            new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            ) {
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            if (!isSuccess) {
                throw new IOException("API request failed with status " + conn.getResponseCode());
            }
        }

        return sb;
    }
    private StringBuilder getUrlBuilder(int longitude, int latitude,
        FormattingTime formattedTime) throws UnsupportedEncodingException {
        StringBuilder urlBuilder = new StringBuilder(WEATHER_REQUEST_BASE_URL); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey",ENCODING) + "="+serviceKey); /*Service Key*/
        urlBuilder.append(appendUrlParameter("pageNo","1")); /*페이지번호*/
        urlBuilder.append(appendUrlParameter("numOfRows","12"));
        urlBuilder.append(appendUrlParameter("dataType","JSON"));
        urlBuilder.append(appendUrlParameter("base_date",formattedTime.requestDate().replaceAll("-", "")));
        urlBuilder.append(appendUrlParameter("base_time",formattedTime.requestTime()));
        urlBuilder.append(appendUrlParameter("nx",String.valueOf(latitude)));
        urlBuilder.append(appendUrlParameter("ny",String.valueOf(longitude)));
        return urlBuilder;
    }
    private static String appendUrlParameter(String key,String value) throws UnsupportedEncodingException {
        return "&" + URLEncoder.encode(key, ENCODING) + "=" + URLEncoder.encode(value, ENCODING);
    }

    private static FormattingTime getFormattedTime() {
        return new FormattingTime(
            formatDate(LocalDateTime.now().toLocalDate()),
            formatTime(getNearestTime(getTime()).selectedTime)
        );
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
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = (now.getMinute()/10)*10;
        return hour +String.valueOf(minute);
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
    private static String formatTime(int time) {
        return String.format("%04d", time);
    }
    private static String formatDate(LocalDate date) {
        return date.toString().replaceAll("-", "");
    }
}
