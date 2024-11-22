package com.ssafy.commerce.demo.boardImage.dto;

public class BoardImage {
	private int id;
	private int userId;
	private int boardId;
	private String fileName;
	private String filePath;
	
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
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public String toString() {
		return "BoardImage [id=" + id + ", userId=" + userId + ", boardId=" + boardId + ", fileName=" + fileName
				+ ", filePath=" + filePath + "]";
	}
}
