package com.ssafy.commerce.demo.user.dto;

public class Fortune {
	private int id;
	private String zodiacSign;
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZodiacSign() {
		return zodiacSign;
	}
	public void setZodiacSign(String zodiacSign) {
		this.zodiacSign = zodiacSign;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Fortune [id=" + id + ", zodiacSign=" + zodiacSign + ", content=" + content + "]";
	}
}
