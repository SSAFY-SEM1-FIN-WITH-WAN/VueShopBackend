package com.ssafy.commerce.demo.cloth.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssafy.commerce.demo.cloth.entity.Cloth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // null 값은 직렬화에서 제외
public class ClothResponseDto {

    

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		 for(ClothImage val : images) {
			sb.append((val.toString()));
		}
		 return sb.toString();
	}
	
}
