package com.ssafy.commerce.demo.comment.dao;

import java.util.List;

import com.ssafy.commerce.demo.comment.dto.Comment;
import com.ssafy.commerce.demo.comment.dto.CommentWithUserProfile;

public interface CommentDao {

//	public List<Comment> selectAll(int boardId);
	
	public List<CommentWithUserProfile> selectAll(int boardId);
	
	public Comment selectOne(int id);
	
	public int insertComment(Comment comment);
	
	public int updateComment(Comment comment);
	
	public int deleteComment(int id);
}
