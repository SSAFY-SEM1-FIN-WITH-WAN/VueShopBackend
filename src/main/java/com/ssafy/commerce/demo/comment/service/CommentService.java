package com.ssafy.commerce.demo.comment.service;

import java.util.List;

import com.ssafy.commerce.demo.comment.dto.Comment;

public interface CommentService {

	public List<Comment> getCommentList(int boardId);
	
	public Comment getComment(int id);
	
	public boolean addComment(Comment comment);
	
	public boolean modifyComment(Comment comment);
	
	public boolean removeComment(int id);
}
