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
    public static final String reqTime2 = String.format("%02d30",LocalDateTime.now().getHour()-2);
    public static final String DEFAULT_PAGE_NO = "3";
    public static final String DEFAULT_ROWS = "20";
    
	private WeatherService weatherService;
	
	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@GetMapping
	@TimeTrace
	public ResponseEntity<?> requestWeather(double longitude, double latitude) throws IOException{
		WeatherResponseDto dto = weatherService.requestWeather(longitude,latitude,WEATHER_REQUEST_BASE_URL,reqTime,"3","20");
		List<Item> itemList = dto.getResponse().getBody().getItems().getItem();
		List<Item> filteredList = new ArrayList<>();
		for(Item item : itemList) {
			if(item.getFcstTime().equals(String.format("0600"))&&item.getCategory().equals("TMN")) {
				filteredList.add(item);
			}
		}
		dto.getResponse().getBody().getItems().setItem(filteredList);
//		System.out.println("--------------------------------------------");
		System.out.println(dto.toString());
		return ResponseEntity.ok(dto);
	}
	
	@TimeTrace
	@GetMapping("/2")
	public ResponseEntity<?> requestWeather2(double longitude, double latitude) throws IOException{
		WeatherResponseDto dto = weatherService.requestWeather(longitude,latitude,WEATHER_REQUEST_BASE_URL2,reqTime2,"6","5");
//		System.out.println(dto.toString());
		List<Item> itemList = dto.getResponse().getBody().getItems().getItem();
		List<Item> filteredList = new ArrayList<>();
		for(Item item : itemList) {
			if(item.getFcstTime().equals(String.format("%02d00",LocalDateTime.now().getHour()))) {
				filteredList.add(item);
			}
				
		}
		dto.getResponse().getBody().getItems().setItem(filteredList);
		return ResponseEntity.ok(dto);
	}
	
	@TimeTrace
	@GetMapping("/3")
	public ResponseEntity<?> requestWeather3(double longitude, double latitude) throws IOException{
		WeatherResponseDto dto = weatherService.requestWeather(longitude,latitude,WEATHER_REQUEST_BASE_URL,reqTime,"8","20");
//		System.out.println(dto.toString());
		List<Item> itemList = dto.getResponse().getBody().getItems().getItem();
		List<Item> filteredList = new ArrayList<>();
		for(Item item : itemList) {
			if(item.getFcstTime().equals(String.format("1500"))&&item.getCategory().equals("TMX")) {
				filteredList.add(item);
			}
		}
		dto.getResponse().getBody().getItems().setItem(filteredList);
		return ResponseEntity.ok(dto);
	}
	
	@TimeTrace
	@GetMapping("/4")
	public ResponseEntity<?> requestWeather4(double longitude, double latitude) throws IOException{
		WeatherResponseDto dto = weatherService.requestWeather(longitude,latitude,WEATHER_REQUEST_BASE_URL2,reqTime2,"1","500");
//		System.out.println(dto.toString());
		List<Item> itemList = dto.getResponse().getBody().getItems().getItem();
		List<Item> filteredList = new ArrayList<>();
		for(Item item : itemList) {
			if(item.getFcstTime().equals(String.format("%02d00",LocalDateTime.now().getHour()))&&item.getCategory().equals("PTY")) {
				filteredList.add(item);
			}
				
		}
		dto.getResponse().getBody().getItems().setItem(filteredList);
//		System.out.println("--------------------------------------------");
//		System.out.println(dto.toString());
		return ResponseEntity.ok(dto);
	}
}
