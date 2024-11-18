package com.ssafy.commerce.demo.cloth.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.commerce.demo.cloth.dto.ClothResponseDto;

@Mapper
public interface ClothDao {

	public ClothResponseDto select(double temperature);

}
