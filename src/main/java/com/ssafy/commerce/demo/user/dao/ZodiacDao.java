package com.ssafy.commerce.demo.user.dao;

import com.ssafy.commerce.demo.user.dto.Zodiac;

public interface ZodiacDao {
	
	public Zodiac selectOne(String birthDate);
}
