package com.ssafy.commerce.demo.cloth.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)  // null 값은 직렬화에서 제외
public class Cloth {

    private int id;

    @JsonProperty("cloth_name") // JSON에서 'name' 대신 'cloth_name'으로 표시
    private String name;

    private String category;

    @JsonProperty("min_temperature") // JSON에서 'minTemp' 대신 'min_temperature'으로 표시
    private double minTemp;

    @JsonProperty("max_temperature") // JSON에서 'maxTemp' 대신 'max_temperature'으로 표시
    private double maxTemp;

    private String type;

    @JsonProperty("image_url") // JSON에서 'imageUrl' 대신 'image_url'로 표시
    private String imageUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    
}
