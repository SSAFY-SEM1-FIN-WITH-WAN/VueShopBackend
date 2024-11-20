package com.ssafy.commerce.demo.user.dto;

public class PasswordFinder {
	private String accountId;
	private String nickname;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "PasswordFinder [accountId=" + accountId + ", nickname=" + nickname + "]";
	}
}