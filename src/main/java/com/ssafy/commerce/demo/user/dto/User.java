package com.ssafy.commerce.demo.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
	private int id;
	private String type;
	private String accountId;
	private String password;
	private String nickname;
	private LocalDate birthDate;
	private String zodiacSign;
	private LocalDateTime createdAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getZodiacSign() {
		return zodiacSign;
	}
	public void setZodiacSign(String zodiacSign) {
		this.zodiacSign = zodiacSign;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", type=" + type + ", accountId=" + accountId + ", password=" + password
				+ ", nickname=" + nickname + ", birthDate=" + birthDate + ", zodiacSign=" + zodiacSign + ", createdAt="
				+ createdAt + "]";
	}
}