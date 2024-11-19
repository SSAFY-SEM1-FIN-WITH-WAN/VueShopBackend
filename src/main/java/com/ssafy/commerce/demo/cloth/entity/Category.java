package com.ssafy.commerce.demo.cloth.entity;

public enum Category {

	SHIRT,TSHIRT,
	
	JEANS,SLACKS,SHORTS,
	
	PADDING,COAT,
	
	SANDALS,BOOTS,SNEAKERS;
	
	@Override
	public String toString() {
		return name();
	}
	
}
