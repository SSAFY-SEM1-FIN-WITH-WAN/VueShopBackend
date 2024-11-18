package com.ssafy.commerce.demo.cloth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.commerce.demo.cloth.dao.ClothDao;
import com.ssafy.commerce.demo.cloth.dto.ClothResponseDto;

@Service
public class ClothServiceImpl implements ClothService{

	private ClothDao clothdao;
	public ClothServiceImpl(ClothDao clothdao) {
		this.clothdao = clothdao;
	}
	
	public ClothResponseDto requestCloth(double temperature) {
		return clothdao.select(temperature);
	}

}
