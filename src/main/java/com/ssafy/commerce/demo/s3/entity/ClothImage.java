package com.ssafy.commerce.demo.s3.entity;


public class ClothImage {

	private int id;
	private String originalName;
	private String uniqueName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getUniqueName() {
		return uniqueName;
	}
	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}
	@Override
	public String toString() {
		return "ClothImage [id=" + id + ", originalName=" + originalName + ", uniqueName=" + uniqueName + ", minTemp="
				+ minTemp + ", maxTemp=" + maxTemp + "]";
	}
	
	
}
