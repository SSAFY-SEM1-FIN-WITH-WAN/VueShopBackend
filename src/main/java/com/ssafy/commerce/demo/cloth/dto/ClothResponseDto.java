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

    private List<Cloth> tops;
    private List<Cloth> bottoms;
    private List<Cloth> outers;
    private List<Cloth> shoes;

    public ClothResponseDto(List<Cloth> tops, List<Cloth> bottoms, List<Cloth> outers, List<Cloth> shoes) {
        this.tops = tops;
        this.bottoms = bottoms;
        this.outers = outers;
        this.shoes = shoes;
    }

	public List<Cloth> getTops() {
		return tops;
	}

	public void setTops(List<Cloth> tops) {
		this.tops = tops;
	}

	public List<Cloth> getBottoms() {
		return bottoms;
	}

	public void setBottoms(List<Cloth> bottoms) {
		this.bottoms = bottoms;
	}

	public List<Cloth> getOuters() {
		return outers;
	}

	public void setOuters(List<Cloth> outers) {
		this.outers = outers;
	}

	public List<Cloth> getShoes() {
		return shoes;
	}

	public void setShoes(List<Cloth> shoes) {
		this.shoes = shoes;
	}
    
    
}
