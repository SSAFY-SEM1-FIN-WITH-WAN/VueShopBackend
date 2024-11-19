package com.ssafy.commerce.demo.cloth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.commerce.demo.cloth.entity.Cloth;
import com.ssafy.commerce.demo.cloth.entity.Type;

@Mapper
public interface ClothDao {

	public List<Cloth> selectByTemperatureAndType(@Param("temperature") double temperature,@Param("type") String type);

}
