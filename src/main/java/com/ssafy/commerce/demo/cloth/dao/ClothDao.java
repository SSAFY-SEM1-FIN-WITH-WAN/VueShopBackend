package com.ssafy.commerce.demo.cloth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.commerce.demo.cloth.entity.Cloth;
import com.ssafy.commerce.demo.cloth.entity.Type;
import com.ssafy.commerce.demo.s3.entity.ClothImage;

@Mapper
public interface ClothDao {

	public List<Cloth> selectByTemperatureAndType(@Param("temperature") double temperature,@Param("type") String type);
	public List<ClothImage> selectImageByTemperature(double temperature);
}
