package com.ssafy.commerce.demo.cloth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.commerce.demo.cloth.dao.ClothDao;
import com.ssafy.commerce.demo.cloth.dto.ClothResponseDto;
import com.ssafy.commerce.demo.cloth.entity.Cloth;
import com.ssafy.commerce.demo.cloth.entity.Type;

@Service
public class ClothServiceImpl implements ClothService{

	private ClothDao clothdao;
	public ClothServiceImpl(ClothDao clothdao) {
		this.clothdao = clothdao;
	}
	
	public ClothResponseDto requestCloth(double temperature) {
	    List<Cloth> tops = clothdao.selectByTemperatureAndType(temperature, Type.TOPS.toString());
	    List<Cloth> bottoms = clothdao.selectByTemperatureAndType(temperature, Type.BOTTOMS.toString());
	    List<Cloth> outers = clothdao.selectByTemperatureAndType(temperature, Type.OUTERS.toString());
	    List<Cloth> shoes = clothdao.selectByTemperatureAndType(temperature, Type.SHOES.toString());

	    return new ClothResponseDto(tops, bottoms, outers, shoes);
	}


}
