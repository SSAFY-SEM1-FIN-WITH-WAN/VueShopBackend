package com.ssafy.commerce.demo.comment.dto;

import java.time.LocalDateTime;

public class CommentWithUserProfile {
	private int id;
	private int userId;
	private String userName;
	private String userFilePath;
	private int boardId;
	private String content;
	private LocalDateTime createdAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserFilePath() {
		return userFilePath;
	}
	public void setUserFilePath(String userFilePath) {
		this.userFilePath = userFilePath;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "CommentWithUserProfile [id=" + id + ", userId=" + userId + ", userName=" + userName + ", userFilePath="
				+ userFilePath + ", boardId=" + boardId + ", content=" + content + ", createdAt=" + createdAt + "]";
	}
}
