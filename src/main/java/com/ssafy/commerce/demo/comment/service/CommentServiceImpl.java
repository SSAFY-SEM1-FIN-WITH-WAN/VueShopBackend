package com.ssafy.commerce.demo.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.commerce.demo.comment.dao.CommentDao;
import com.ssafy.commerce.demo.comment.dto.Comment;
import com.ssafy.commerce.demo.comment.dto.CommentWithUserProfile;

@Service
public class CommentServiceImpl implements CommentService {
	
	private final CommentDao commentDao;
	
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

//	@Override
//	public List<Comment> getCommentList(int boardId) {
//		
//		List<Comment> comments = commentDao.selectAll(boardId);
//		for (Comment comment : comments)
//			System.out.println(comment);
//		return comments;
//	}
	
	@Override
	public List<CommentWithUserProfile> getCommentList(int boardId) {
		
		List<CommentWithUserProfile> comments = commentDao.selectAll(boardId);
		for (CommentWithUserProfile comment : comments)
			System.out.println(comment);
		return comments;
	}
	
	@Override
	public Comment getComment(int id) {
		
		Comment comment = commentDao.selectOne(id);
		System.out.println(comment);
		return comment;
	}

	@Override
	public boolean addComment(Comment comment) {

		boolean result = commentDao.insertComment(comment) == 1;
		System.out.println(comment + " | " + result);
		return result;
	}

	@Override
	public boolean modifyComment(Comment comment) {
		
		boolean result = commentDao.updateComment(comment) == 1;
		System.out.println(comment + " | " + result);
		return result;
	}

	@Override
	public boolean removeComment(int id) {

		boolean result = commentDao.deleteComment(id) == 1;
		System.out.println(id + " | " + result);
		return result;
	}

}
