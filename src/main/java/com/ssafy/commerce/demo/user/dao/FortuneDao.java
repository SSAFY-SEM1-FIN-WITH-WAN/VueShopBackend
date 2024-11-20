package com.ssafy.commerce.demo.user.dao;

import java.util.List;

import com.ssafy.commerce.demo.user.dto.Fortune;

public interface FortuneDao {
	
	public List<Fortune> selectAll(String zodiacSign);
}
