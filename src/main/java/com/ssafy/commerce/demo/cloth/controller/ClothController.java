package com.ssafy.commerce.demo.cloth.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.commerce.demo.cloth.dto.ClothResponseDto;
import com.ssafy.commerce.demo.cloth.service.ClothService;
import com.ssafy.commerce.demo.weather.dto.WeatherResponseDto;
import com.ssafy.commerce.demo.weather.service.WeatherService;

@RestController
@RequestMapping("api/v1")
public class ClothController {

	private ClothService clothService;
	
	public ClothController(ClothService clothService) {
		this.clothService = clothService;
	}
	
	@GetMapping("/cloth")
	public ResponseEntity<ClothResponseDto> requestCloth(@RequestParam double temperature) {
		ClothResponseDto dto = clothService.requestCloth(temperature);
		System.out.println(dto.toString());
		return ResponseEntity.ok(dto);
	}
}