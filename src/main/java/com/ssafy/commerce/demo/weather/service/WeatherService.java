package com.ssafy.commerce.demo.weather.service;

import java.io.IOException;

import com.ssafy.commerce.demo.weather.dto.WeatherResponseDto;

public interface WeatherService {

	public WeatherResponseDto requestWeather(double longitude, double latitude,String type,String timeValue,String pageNo, String pageRows) throws IOException;


}
