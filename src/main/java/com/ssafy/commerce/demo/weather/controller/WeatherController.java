package com.ssafy.commerce.demo.weather.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.commerce.demo.weather.dto.WeatherResponseDto;
import com.ssafy.commerce.demo.weather.service.WeatherService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/weather")
public class WeatherController {

	private WeatherService weatherService;
	@Autowired
	private WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@GetMapping
	public ResponseEntity<?> requestWeather(double longitude, double latitude) throws IOException{
		WeatherResponseDto dto = weatherService.requestWeather(longitude,latitude);
		return ResponseEntity.ok(dto);
	}
}
