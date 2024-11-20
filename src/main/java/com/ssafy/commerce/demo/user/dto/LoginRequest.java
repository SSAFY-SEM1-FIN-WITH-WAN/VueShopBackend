package com.ssafy.commerce.demo.user.dto;

public class LoginRequest {
	private String accountId;
	private String password;
	
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
	
	@Override
	public String toString() {
		return "LoginRequest [accountId=" + accountId + ", password=" + password + "]";
	}
}