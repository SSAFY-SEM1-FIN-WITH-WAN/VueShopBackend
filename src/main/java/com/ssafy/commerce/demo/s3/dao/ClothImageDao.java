package com.ssafy.commerce.demo.s3.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.commerce.demo.s3.entity.ClothImage;

@Mapper
public interface ClothImageDao {
	void insertImage(ClothImage image);
	ClothImage selectImageByUniqueName(String uniqueName);
}
