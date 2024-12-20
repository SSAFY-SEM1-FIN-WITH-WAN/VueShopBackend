package com.ssafy.commerce.demo.weather.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.commerce.demo.utils.annotation.TimeTrace;
import com.ssafy.commerce.demo.weather.dto.WeatherResponseDto;
import com.ssafy.commerce.demo.weather.dto.WeatherResponseDto.Body.Items.Item;
import com.ssafy.commerce.demo.weather.service.WeatherService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/weather")
public class WeatherController {

	private static final String WEATHER_REQUEST_BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
	private static final String WEATHER_REQUEST_BASE_URL2 = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";
	public static final String reqTime = String.format("0200");
	public static final String reqTime2 = String.format("%02d30", LocalDateTime.now().getHour() - 2);
	public static final String reqTime3 = String.format("%02d00", LocalDateTime.now().getHour()-1);
	public static final String DEFAULT_PAGE_NO = "3";
	public static final String DEFAULT_ROWS = "20";

	private WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;	
	}

	@GetMapping("/TMN")
	@TimeTrace
	public ResponseEntity<?> requestWeatherTMN(double longitude, double latitude) throws IOException {
		return requestWeatherWithFilter(longitude, latitude, WEATHER_REQUEST_BASE_URL, reqTime, "3", "20", "0600", "TMN");
	}

	@GetMapping("/CurrentTMP")
	@TimeTrace
	public ResponseEntity<?> requestWeatherCurrentTMP(double longitude, double latitude) throws IOException {
		return requestWeatherWithFilter(longitude, latitude, WEATHER_REQUEST_BASE_URL2, reqTime2, "6", "5", String.format("%02d00", LocalDateTime.now().getHour()), null);
	}

	@GetMapping("/TMX")
	@TimeTrace
	public ResponseEntity<?> requestWeatherTMX(double longitude, double latitude) throws IOException {
		return requestWeatherWithFilter(longitude, latitude, WEATHER_REQUEST_BASE_URL, reqTime, "8", "20", "1500", "TMX");
	}

	@GetMapping("/PTY")
	@TimeTrace
	public ResponseEntity<?> requestWeatherPTY(double longitude, double latitude) throws IOException {
		return requestWeatherWithFilter(longitude, latitude, WEATHER_REQUEST_BASE_URL2, reqTime3, "2", "6", String.format("%02d00", LocalDateTime.now().getHour()), "PTY");
	}
	
	@GetMapping("/SKY")
	@TimeTrace
	public ResponseEntity<?> requestWeatherSKY(double longitude, double latitude) throws IOException {
		return requestWeatherWithFilter(longitude, latitude, WEATHER_REQUEST_BASE_URL2, reqTime3, "4", "6", String.format("%02d00", LocalDateTime.now().getHour()), "SKY");
	}

	private ResponseEntity<?> requestWeatherWithFilter(double longitude, double latitude, String baseUrl, String reqTime, String pageNo, String numOfRows, String fcstTime, String category) throws IOException {
		WeatherResponseDto dto = weatherService.requestWeather(longitude, latitude, baseUrl, reqTime, pageNo, numOfRows);
		List<Item> itemList = dto.getResponse().getBody().getItems().getItem();
		List<Item> filteredList = new ArrayList<>();
		for (Item item : itemList) {
			if (item.getFcstTime().equals(fcstTime) && (category == null || item.getCategory().equals(category))) {
				filteredList.add(item);
			}
		}
		dto.getResponse().getBody().getItems().setItem(filteredList);
		return ResponseEntity.ok(dto);
	}
}