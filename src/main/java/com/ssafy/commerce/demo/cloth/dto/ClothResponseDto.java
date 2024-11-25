package com.ssafy.commerce.demo.cloth.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssafy.commerce.demo.cloth.entity.Cloth;
import com.ssafy.commerce.demo.s3.entity.ClothImage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // null 값은 직렬화에서 제외
public class ClothResponseDto {

    private List<ClothImage> images;

    public ClothResponseDto(List<ClothImage> images) {
    	this.images=images;
    }

	public List<ClothImage> getImages() {
		return images;
	}

	public void setImages(List<ClothImage> images) {
		this.images = images;
	}
}
